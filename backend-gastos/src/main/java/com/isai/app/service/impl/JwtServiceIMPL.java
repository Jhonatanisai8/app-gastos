package com.isai.app.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.isai.app.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtServiceIMPL implements JwtService {
    @Override
    public String obtenerToken(UserDetails usuario) {

    }
}