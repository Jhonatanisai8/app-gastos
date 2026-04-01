package com.isai.app.models.dtos.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequest {

    @NotBlank(message = "El nombre de la categoría no puede estar vacío")
    @Size(max = 20, message = "El nombre de la categoría no puede exceder los 20 caracteres")
    @Pattern(regexp = "^(?!^\\d+$)[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre de la categoría no puede ser solo números y debe ser válido")
    private String nombre;

    @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
    private String descripcion;
}
