package com.isai.app.service;

import com.isai.app.models.dtos.req.LoginRequest;
import com.isai.app.models.dtos.req.RegistroRequest;
import com.isai.app.models.dtos.res.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);

    AuthResponse registro(RegistroRequest registroRequest);
}
