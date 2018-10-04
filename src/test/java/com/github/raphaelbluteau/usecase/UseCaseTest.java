package com.github.raphaelbluteau.usecase;

import com.github.raphaelbluteau.enums.DishType;
import com.github.raphaelbluteau.enums.Period;
import com.github.raphaelbluteau.exceptions.NotApplicableDish;
import com.github.raphaelbluteau.usecase.data.UseCaseDto;
import com.github.raphaelbluteau.usecase.impl.UseCaseImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UseCaseTest {

  private UseCase useCase;
  private List<DishType> typesList;

  @Before
  public void setUp() {

    typesList = Arrays.asList(DishType.ENTREE, DishType.SIDE, DishType.DRINK, DishType.DESSERT);
    useCase = new UseCaseImpl();
  }

  @Test
  public void getDishes() {

    List<UseCaseDto> dishes = useCase.getDishes();
    Assert.assertNotNull(dishes);
    Assert.assertFalse(dishes.isEmpty());
    Assert.assertTrue(dishes.size() > 1);
    Assert.assertNotNull(dishes.get(0));
  }

  @Test
  public void isValidChoice() {

    Assert.assertFalse(useCase.isValidChoice(Period.MORNING, DishType.DESSERT));
    Assert.assertTrue(useCase.isValidChoice(Period.NIGHT, DishType.SIDE));
  }

  @Test
  public void getChoices() throws NotApplicableDish {

    String choices = useCase.getChoices(Period.NIGHT, typesList);
    Assert.assertNotNull(choices);
    Assert.assertTrue(choices.equalsIgnoreCase("steak, potato, wine, cake"));

    choices = useCase.getChoices(Period.MORNING, typesList);
    Assert.assertNotNull(choices);
    Assert.assertTrue(choices.equalsIgnoreCase("eggs, toast, coffee, error"));

    typesList = Arrays
        .asList(DishType.DRINK, DishType.DRINK, DishType.DRINK, DishType.DRINK, DishType.ENTREE,
            DishType.SIDE, DishType.DESSERT);
    choices = useCase.getChoices(Period.MORNING, typesList);
    Assert.assertNotNull(choices);
    Assert.assertTrue(choices.equalsIgnoreCase("eggs, toast, coffee(4x), error"));

  }

}