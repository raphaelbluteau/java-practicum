package com.github.raphaelbluteau.usecase;

import com.github.raphaelbluteau.enums.DishType;
import com.github.raphaelbluteau.enums.Period;
import com.github.raphaelbluteau.exceptions.NotApplicableDish;
import com.github.raphaelbluteau.usecase.data.UseCaseDto;
import java.util.List;

public interface UseCase {

  List<UseCaseDto> getDishes();

  boolean isValidChoice(Period period, DishType type);

  String getChoices(Period period, List<DishType> types) throws NotApplicableDish;

}
