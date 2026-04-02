package com.isai.app.models.dtos.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistroRequest {
    private String username;
    private String password;
    private String nombres;
    private String apellidos;
    private String ciudad;
}
