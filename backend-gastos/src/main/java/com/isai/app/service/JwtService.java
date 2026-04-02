package com.isai.app.service;

import org.springframework.security.core.userdetails.UserDetails;


public interface JwtService {
    String obtenerToken(UserDetails usuario);

    boolean esTokenValido(String token, UserDetails userDetails);

    String obtenerNombreUsuario(String token);
}
