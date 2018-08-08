package com.github.raphaelbluteau.usecase.converter;

import static org.junit.Assert.*;

import com.github.raphaelbluteau.enums.DishName;
import com.github.raphaelbluteau.enums.DishType;
import com.github.raphaelbluteau.enums.Period;
import com.github.raphaelbluteau.gateway.data.DishGatewayResponse;
import com.github.raphaelbluteau.usecase.converter.impl.UseCaseConverterImpl;
import com.github.raphaelbluteau.usecase.data.UseCaseDto;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UseCaseConverterTest {

  private UseCaseConverter converter;
  private List<DishGatewayResponse> gatewayResponse;

  @Before
  public void setUp() {
    gatewayResponse = Collections.singletonList(new DishGatewayResponse(
        Period.MORNING, DishType.SIDE, DishName.EGGS));
    converter = new UseCaseConverterImpl();


  }

  @Test
  public void toDto() {

    List<UseCaseDto> result = converter.toDto(gatewayResponse);
    Assert.assertNotNull(result);
    Assert.assertEquals(1, result.size());
    Assert.assertEquals(result.get(0).getName(), DishName.EGGS);
    Assert.assertEquals(result.get(0).getPeriod(), Period.MORNING);
    Assert.assertEquals(result.get(0).getType(), DishType.SIDE);
  }
}