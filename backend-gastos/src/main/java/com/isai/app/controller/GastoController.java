package com.isai.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isai.app.models.dtos.req.GastoRequest;
import com.isai.app.models.dtos.res.GastoResponse;
import com.isai.app.service.GastoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/gastos")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class GastoController {

  private final GastoService gastoService;

  @PostMapping()
  public ResponseEntity<GastoResponse> guardarGasto(
      @Valid @RequestBody GastoRequest gastoRequest,
      Authentication authentication) {
    GastoResponse gasto = gastoService.guardarGasto(gastoRequest, authentication);
    return ResponseEntity
        .created(URI.create("/api/v1/gastos/" + gasto.getIdGasto()))
        .body(gasto);
  }

}