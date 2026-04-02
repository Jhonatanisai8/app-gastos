package com.isai.app.controller.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    @PostMapping("/login")
    public String login() {
        return "Hola mundo 1";
    }

    @PostMapping("/registro")
    public String registro() {
        return "Hola Mundo 2";
    }

}
