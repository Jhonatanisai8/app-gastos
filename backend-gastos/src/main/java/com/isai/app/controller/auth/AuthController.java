package com.isai.app.controller.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isai.app.models.dtos.req.LoginRequest;
import com.isai.app.models.dtos.req.RegistroRequest;
import com.isai.app.models.dtos.res.AuthResponse;
import com.isai.app.service.impl.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/registro")
    public ResponseEntity<AuthResponse> registro(@RequestBody RegistroRequest registroRequest) {
        return ResponseEntity.ok(authService.registro(registroRequest));
    }

}
