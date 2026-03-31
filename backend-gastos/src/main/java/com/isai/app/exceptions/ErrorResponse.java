package com.isai.app.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private String codigo;
    private String httpEstado;
    private String mensaje;
    private List<String> detallesMensajes;
    private LocalDateTime fechaHora;
}
