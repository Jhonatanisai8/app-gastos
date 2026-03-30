package com.isai.app.models.dtos;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoriaResponse {

    private Long idCategoria;

    private String nombre;

    private String descripcion;

    private LocalDateTime fechaCreacion;
}