package com.isai.app.models.dtos.res;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GastoResponse {
    private Long idGasto;
    private BigDecimal monto;
    private String descripcion;
    private CategoriaResponse categoria;
    private String metodoPago;

}
