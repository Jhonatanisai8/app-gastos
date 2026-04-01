package com.isai.app.models.dtos.res;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaResponse {

    private Long idCategoria;

    private String nombre;

    private String descripcion;

    private LocalDateTime fechaCreacion;
}