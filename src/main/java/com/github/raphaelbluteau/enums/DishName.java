package com.github.raphaelbluteau.enums;

import java.util.Arrays;
import java.util.Optional;

public enum DishName {

  EGGS("eggs"),
  TOAST("Toast"),
  COFFEE("coffee"),
  STEAK("steak"),
  POTATO("potato"),
  WINE("wine"),
  CAKE("cake");

  private String name;

  DishName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static DishName getEnum(String value) {

    Optional<DishName> dish = Arrays.stream(DishName.values())
        .filter(d -> d.getName().equalsIgnoreCase(value))
        .reduce((d, v) -> {
          throw new IllegalStateException("More than one dish found for this value");
        });

    return dish.orElse(null);

  }
}
