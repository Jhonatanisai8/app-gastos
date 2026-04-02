package com.isai.app.service.impl;

import org.springframework.stereotype.Service;

import com.isai.app.models.dtos.req.LoginRequest;
import com.isai.app.models.dtos.req.RegistroRequest;
import com.isai.app.models.dtos.res.AuthResponse;
import com.isai.app.service.AuthService;

@Service
public class AuthServiceIMPL implements AuthService {

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public AuthResponse registro(RegistroRequest registroRequest) {
        return null;
    }
}
