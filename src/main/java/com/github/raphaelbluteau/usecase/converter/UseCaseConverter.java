package com.github.raphaelbluteau.usecase.converter;

import com.github.raphaelbluteau.gateway.data.DishGatewayResponse;
import com.github.raphaelbluteau.usecase.data.UseCaseDto;
import java.util.List;

public interface UseCaseConverter {

  List<UseCaseDto> toDto(List<DishGatewayResponse> gatewayResponseList);

}
