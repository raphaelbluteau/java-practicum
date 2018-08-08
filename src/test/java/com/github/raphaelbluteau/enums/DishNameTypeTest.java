package com.github.raphaelbluteau.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DishNameTypeTest {

  @Test
  public void testDishType() {

    assertEquals(DishType.getEnum("1"), DishType.ENTREE);
    assertEquals(DishType.getEnum("2"), DishType.SIDE);
    assertEquals(DishType.getEnum("3"), DishType.DRINK);
    assertEquals(DishType.getEnum("4"), DishType.DESSERT);
  }

}
