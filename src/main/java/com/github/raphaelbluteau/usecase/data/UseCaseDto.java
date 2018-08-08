package com.github.raphaelbluteau.usecase.data;

import com.github.raphaelbluteau.enums.DishName;
import com.github.raphaelbluteau.enums.DishType;
import com.github.raphaelbluteau.enums.Period;

public class UseCaseDto {

  private Period period;
  private DishType type;
  private DishName name;

  public UseCaseDto(Period period, DishType type, DishName name) {
    this.period = period;
    this.type = type;
    this.name = name;
  }

  public Period getPeriod() {
    return period;
  }

  public DishType getType() {
    return type;
  }

  public DishName getName() {
    return name;
  }
}
