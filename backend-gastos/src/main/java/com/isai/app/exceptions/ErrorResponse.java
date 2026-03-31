package com.isai.app.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String codigo;
    private String httpEstado;
    private String mensaje;
    private List<String> detallesMensajes;
    private LocalDateTime fechaHora;
}
