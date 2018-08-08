package com.github.raphaelbluteau.gateway;

import static org.junit.Assert.*;

import com.github.raphaelbluteau.gateway.data.DishGatewayResponse;
import com.github.raphaelbluteau.gateway.impl.DishGatewayImpl;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DishGatewayTest {

  private DishGateway gateway;

  @Before
  public void setUp() {

    gateway = new DishGatewayImpl();
  }

  @Test
  public void getDishes() {

    List<DishGatewayResponse> dishes = gateway.getDishes();
    Assert.assertNotNull(dishes);
    Assert.assertTrue(dishes.size() > 1);
    Assert.assertNotNull(dishes.get(0));
  }
}