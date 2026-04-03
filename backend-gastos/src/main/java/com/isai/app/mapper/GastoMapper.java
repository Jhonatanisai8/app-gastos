package com.isai.app.mapper;

import org.mapstruct.Mapper;

import com.isai.app.models.dtos.res.GastoResponse;
import com.isai.app.models.entities.Gasto;

@Mapper(componentModel = "spring")
public interface GastoMapper {
    GastoResponse toGastoResponse(Gasto gasto);
}