package com.github.raphaelbluteau.enums;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

public enum Period {

  MORNING("morning"),
  NIGHT("night");

  private String name;

  Period(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static Period getEnum(String value) {

    Optional<Period> period = Arrays.stream(Period.values())
        .filter(d -> d.getName().equalsIgnoreCase(value))
        .reduce((d, v) -> {
          throw new IllegalStateException("More than one period found for this value");
        });

    return period.orElse(null);

  }

  @Override
  public String toString() {
    return name.toLowerCase(Locale.ENGLISH);
  }
}
