package com.isai.app.service;

import java.math.BigDecimal;

import org.springframework.security.core.Authentication;

import com.isai.app.models.dtos.req.GastoRequest;
import com.isai.app.models.dtos.res.GastoResponse;

public interface GastoService {

  GastoResponse guardarGasto(GastoRequest gastoRequest, Authentication authentication);

  BigDecimal obtenerTotalGastadoPorUsuario(Authentication authentication);
}
