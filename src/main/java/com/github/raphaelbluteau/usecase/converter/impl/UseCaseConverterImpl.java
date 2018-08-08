package com.github.raphaelbluteau.usecase.converter.impl;

import com.github.raphaelbluteau.gateway.data.DishGatewayResponse;
import com.github.raphaelbluteau.usecase.converter.UseCaseConverter;
import com.github.raphaelbluteau.usecase.data.UseCaseDto;
import java.util.List;
import java.util.stream.Collectors;

public class UseCaseConverterImpl implements UseCaseConverter {

  @Override
  public List<UseCaseDto> toDto(List<DishGatewayResponse> gatewayResponseList) {

    return gatewayResponseList.stream()
        .map(this::toDto)
        .collect(Collectors.toList());

  }

  private UseCaseDto toDto(DishGatewayResponse gatewayResponse) {

    return new UseCaseDto(gatewayResponse.getPeriod(), gatewayResponse.getType(),
        gatewayResponse.getName());

  }
}
