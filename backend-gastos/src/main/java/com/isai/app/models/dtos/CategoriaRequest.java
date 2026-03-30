package com.isai.app.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaRequest {

    @NotEmpty(message = "El nombre de la categoría no puede estar vacío")
    private String nombre;

    private String descripcion;
}
