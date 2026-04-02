package com.isai.app.service.impl;

import java.security.Key;
import java.security.Signature;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.isai.app.service.JwtService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@Service
public class JwtServiceIMPL implements JwtService {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Override
    public String obtenerToken(UserDetails usuario) {
        return obtenerToken(new HashMap<>(), usuario);
    }

    private String obtenerToken(Map<String, Object> extraClaims, UserDetails usuario) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(usuario.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(obtenerClave())
                .compact();
    }

    private Key obtenerClave() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}