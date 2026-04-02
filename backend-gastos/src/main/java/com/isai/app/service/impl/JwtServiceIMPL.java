package com.isai.app.service.impl;

import java.security.Key;
import java.security.Signature;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.isai.app.service.JwtService;

import io.jsonwebtoken.Claims;
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

    @Override
    public boolean esTokenValido(String token, UserDetails userDetails) {
        final String userName = obtenerNombreUsuario(token);
        return (userName.equals(userDetails.getUsername()) && !esTokenExpirado(token));
    }

    @Override
    public String obtenerNombreUsuario(String token) {
        return obtenerClaim(token, Claims::getSubject);
    }

    private Claims obtenerClaims(String token) {
        return Jwts.parser()
                .setSigningKey(obtenerClave())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T obtenerClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = obtenerClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date obtenetFechaExperacion(String token) {
        return obtenerClaim(token, Claims::getExpiration);
    }

    private boolean esTokenExpirado(String token) {
        return obtenetFechaExperacion(token)
                .before(new Date());
    }

}