package com.isai.app.models.dtos.res;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GastoResponse {
    private Long idGasto;
    private BigDecimal monto;
    private String descripcion;
    private CategoriaResponse categoria;
    private String metodoPago;

}
