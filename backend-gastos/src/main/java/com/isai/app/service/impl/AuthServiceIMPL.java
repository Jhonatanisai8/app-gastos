package com.isai.app.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isai.app.mapper.UsuarioMapper;
import com.isai.app.models.dtos.req.LoginRequest;
import com.isai.app.models.dtos.req.UsuarioRegistroRequest;
import com.isai.app.models.dtos.res.AuthResponse;
import com.isai.app.models.entities.Usuario;
import com.isai.app.models.enums.Rol;
import com.isai.app.repository.UsuarioRepository;
import com.isai.app.service.AuthService;
import com.isai.app.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public AuthResponse registro(UsuarioRegistroRequest usuarioRegistroRequest) {
        Usuario usuario = usuarioMapper.toUsuario(usuarioRegistroRequest);
        usuario.setRol(Rol.USUARIO);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        AuthResponse authResponse = usuarioMapper.toUsuarioResponse(usuarioGuardado);
        authResponse.setToken(jwtService.obtenerToken(usuarioGuardado));
        return authResponse;
    }
}
