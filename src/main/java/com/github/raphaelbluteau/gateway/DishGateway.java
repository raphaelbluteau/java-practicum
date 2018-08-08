package com.github.raphaelbluteau.gateway;

import com.github.raphaelbluteau.gateway.data.DishGatewayResponse;
import java.util.List;

public interface DishGateway {

  List<DishGatewayResponse> getDishes();

}
