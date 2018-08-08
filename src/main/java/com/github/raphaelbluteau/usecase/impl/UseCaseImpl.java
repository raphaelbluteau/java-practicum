package com.github.raphaelbluteau.usecase.impl;

import com.github.raphaelbluteau.enums.DishType;
import com.github.raphaelbluteau.enums.Period;
import com.github.raphaelbluteau.exceptions.NotApplicableDish;
import com.github.raphaelbluteau.gateway.DishGateway;
import com.github.raphaelbluteau.usecase.UseCase;
import com.github.raphaelbluteau.usecase.converter.UseCaseConverter;
import com.github.raphaelbluteau.usecase.data.UseCaseDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;


public class UseCaseImpl implements UseCase {

  private DishGateway gateway;
  private UseCaseConverter converter;

  public UseCaseImpl(DishGateway gateway,
      UseCaseConverter converter) {
    this.gateway = gateway;
    this.converter = converter;
  }

  @Override
  public List<UseCaseDto> getDishes() {

    return converter.toDto(gateway.getDishes());
  }

  @Override
  public boolean isValidChoice(Period period, DishType type) {

    List<UseCaseDto> dishes = getDishes();

    return dishes.stream().anyMatch(
        u -> u.getPeriod().equals(period) && u.getType().equals(type) && u.getName() != null);

  }

  @Override
  public String getChoices(Period period, List<DishType> types) throws NotApplicableDish {

    List<String> choices = new ArrayList<>();
    HashMap<DishType, String> choicesMap = new HashMap<>();

    for (DishType type : types) {

      if (period.equals(Period.MORNING) && type.equals(DishType.DESSERT)) {
        choicesMap.put(type, "error");
      } else {
        choicesMap.put(type, getUseCaseDTO(period, type).getName().getName());
      }

    }

    for (DishType item : DishType.values()) {
      long count = types.stream().filter(t -> t.equals(item)).count();
      if (count > 1) {
        if (canOrderMultipleTimes(period, item)) {
          String dishLabel = String
              .format("%s(%sx)", getUseCaseDTO(period, item).getName().getName(),
                  String.valueOf(count));
          choicesMap.put(item, dishLabel);
        } else {
          throw new NotApplicableDish(String
              .format("You can't order multiple items of type %d at the %s period", item.getCode(),
                  period.getName()));
        }
      }
    }

    LinkedHashMap<DishType, String> result = choicesMap.entrySet().stream()
        .sorted(Entry.comparingByKey())
        .collect(Collectors
            .toMap(Entry::getKey, Entry::getValue, (oldValue, newValue) -> oldValue,
                LinkedHashMap::new));

    result.forEach((key, value) -> choices.add(value));

    return String.join(", ", choices);

  }

  private UseCaseDto getUseCaseDTO(Period period, DishType type) {

    List<UseCaseDto> dishes = getDishes();

    Optional<UseCaseDto> useCaseDto = dishes.stream()
        .filter(u -> u.getType().equals(type) && u.getPeriod().equals(period))
        .reduce((d, v) -> {
          throw new IllegalStateException("More than one item found for this period and type");
        });

    return useCaseDto.orElse(null);
  }

  private boolean canOrderMultipleTimes(Period period, DishType type) {

    switch (period) {
      case MORNING:
        return type.equals(DishType.DRINK);
      case NIGHT:
        return type.equals(DishType.SIDE);
      default:
        return false;
    }
  }


}
