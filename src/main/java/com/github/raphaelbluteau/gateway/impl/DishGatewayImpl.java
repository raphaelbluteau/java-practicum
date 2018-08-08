package com.github.raphaelbluteau.gateway.impl;

import com.github.raphaelbluteau.enums.DishName;
import com.github.raphaelbluteau.enums.DishType;
import com.github.raphaelbluteau.enums.Period;
import com.github.raphaelbluteau.gateway.DishGateway;
import com.github.raphaelbluteau.gateway.data.DishGatewayResponse;
import java.util.ArrayList;
import java.util.List;

public class DishGatewayImpl implements DishGateway {

  @Override
  public List<DishGatewayResponse> getDishes() {

    // TODO move data to a database
    List<DishGatewayResponse> dishes = new ArrayList<>();
    dishes.add(new DishGatewayResponse(Period.MORNING, DishType.ENTREE, DishName.EGGS));
    dishes.add(new DishGatewayResponse(Period.NIGHT, DishType.ENTREE, DishName.STEAK));
    dishes.add(new DishGatewayResponse(Period.MORNING, DishType.SIDE, DishName.TOAST));
    dishes.add(new DishGatewayResponse(Period.NIGHT, DishType.SIDE, DishName.POTATO));
    dishes.add(new DishGatewayResponse(Period.MORNING, DishType.DRINK, DishName.COFFEE));
    dishes.add(new DishGatewayResponse(Period.NIGHT, DishType.DRINK, DishName.WINE));
    dishes.add(new DishGatewayResponse(Period.MORNING, DishType.DESSERT, null));
    dishes.add(new DishGatewayResponse(Period.NIGHT, DishType.DESSERT, DishName.CAKE));

    return dishes;
  }
}
