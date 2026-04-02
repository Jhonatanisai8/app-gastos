package com.isai.app.mapper;

import org.mapstruct.Mapper;

import com.isai.app.models.dtos.req.UsuarioRegistroRequest;
import com.isai.app.models.dtos.res.AuthResponse;
import com.isai.app.models.entities.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    AuthResponse toUsuarioResponse(Usuario usuario);

    Usuario toUsuario(UsuarioRegistroRequest usuarioRegistroRequest);
}
