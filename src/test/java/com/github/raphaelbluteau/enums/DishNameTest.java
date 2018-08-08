package com.github.raphaelbluteau.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DishNameTest {

  @Test
  public void testDish() {

    assertEquals(DishName.getEnum("Eggs"), DishName.EGGS);
    assertEquals(DishName.getEnum("EGGS"), DishName.EGGS);
    assertEquals(DishName.getEnum("eggs"), DishName.EGGS);

    assertEquals(DishName.getEnum("coffee"), DishName.COFFEE);
    assertEquals(DishName.getEnum("coffEE"), DishName.COFFEE);
    assertEquals(DishName.getEnum("COFFEE"), DishName.COFFEE);

  }

}