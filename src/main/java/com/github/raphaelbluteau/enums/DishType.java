package com.github.raphaelbluteau.enums;

import java.util.Arrays;
import java.util.Optional;

public enum DishType {

  ENTREE(1),
  SIDE(2),
  DRINK(3),
  DESSERT(4);

  private int code;

  DishType(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public static DishType getEnum(String value) {

    Optional<DishType> dish = Arrays.stream(DishType.values())
        .filter(d -> d.getCode() == Integer.valueOf(value))
        .reduce((d, v) -> {
          throw new IllegalStateException("More than one dish type found for this value");
        });

    return dish.orElse(null);

  }
}
