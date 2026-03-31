package com.isai.app.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isai.app.models.dtos.CategoriaRequest;
import com.isai.app.models.dtos.CategoriaResponse;
import com.isai.app.service.CategoriaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponse> guardarCategoria(@Valid @RequestBody CategoriaRequest categoriaRequest) {
        CategoriaResponse categoriaResponse = categoriaService.guardarCategoria(categoriaRequest);
        return ResponseEntity
                .created(URI.create("/api/v1/categorias/" + categoriaResponse.getIdCategoria()))
                .body(categoriaResponse);
    }

}
