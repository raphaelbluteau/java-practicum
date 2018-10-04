package com.github.raphaelbluteau;

import com.github.raphaelbluteau.enums.DishType;
import com.github.raphaelbluteau.enums.Period;
import com.github.raphaelbluteau.exceptions.NotApplicableDish;
import com.github.raphaelbluteau.usecase.UseCase;
import com.github.raphaelbluteau.usecase.data.UseCaseDto;
import com.github.raphaelbluteau.usecase.impl.UseCaseImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

  public static void main(String[] args) {

    UseCase useCase = new UseCaseImpl();

    List<UseCaseDto> dishes = useCase.getDishes();

    System.out.println("Please digit your meal options:");
    String input[];
    Scanner scanner = new Scanner(System.in);
    input = scanner.nextLine().split(",");

    Period period = Period.getEnum(input[0]);
    List<DishType> dishTypes = getDishTypesList(useCase, dishes, input, period);

    try {
      System.out.println(useCase.getChoices(period, dishTypes));
    } catch (NotApplicableDish notApplicableDish) {
      showValidOptionsPerPeriod(dishes, period);
      System.out.println(notApplicableDish.getLocalizedMessage());
    }

  }

  private static List<DishType> getDishTypesList(UseCase useCase, List<UseCaseDto> dishes,
      String[] input,
      Period period) {

    List<DishType> dishTypes = new ArrayList<>();

    for (int i = 1; i < input.length; i++) {
      DishType type = DishType.getEnum(String.valueOf(Integer.valueOf(input[i])));

      if (!useCase.isValidChoice(period, type)) {
        try {
          throw new NotApplicableDish("Not applicable dish type for this period.");
        } catch (NotApplicableDish notApplicableDish) {
          showValidOptionsPerPeriod(dishes, period);
          System.out.println(notApplicableDish.getLocalizedMessage());
        }
      }

      dishTypes.add(type);
    }

    return dishTypes;
  }

  private static void showValidOptionsPerPeriod(List<UseCaseDto> dishes, Period period) {

    System.out
        .println(String.format("These are the valid options for the %s period:", period.getName()));
    dishes.stream().filter(d -> d.getPeriod() == period && d.getName() != null)
        .collect(Collectors.toList()).forEach(d -> {
      System.out.println(d.getType().getCode());
    });
  }


}
