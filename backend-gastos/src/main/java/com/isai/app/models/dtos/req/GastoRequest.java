package com.isai.app.models.dtos.req;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GastoRequest {
    private BigDecimal monto;
    private String descripcion;
    private LocalDate fechaGasto;
    private String metodoPago;
    private Long idCategoria;
    private Long idUsuario;
}
