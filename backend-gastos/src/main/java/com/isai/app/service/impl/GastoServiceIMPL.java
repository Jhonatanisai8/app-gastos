package com.isai.app.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.isai.app.exceptions.CategoriaNotFoundException;
import com.isai.app.exceptions.UsuarioNotFoundException;
import com.isai.app.models.enums.EnumMetodoPago;
import com.isai.app.mapper.GastoMapper;
import com.isai.app.models.dtos.req.GastoRequest;
import com.isai.app.models.dtos.res.GastoResponse;
import com.isai.app.models.entities.Gasto;
import com.isai.app.models.entities.Usuario;
import com.isai.app.repository.CategoriaRepository;
import com.isai.app.repository.GastoRepository;
import com.isai.app.repository.UsuarioRepository;
import com.isai.app.service.GastoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GastoServiceIMPL implements GastoService {

  private final GastoMapper gastoMapper;

  private final GastoRepository gastoRepository;

  private final CategoriaRepository categoriaRepository;

  private final UsuarioRepository usuarioRepository;

  @Override
  public GastoResponse guardarGasto(GastoRequest gastoRequest, Authentication authentication) {
    Usuario usuario = usuarioRepository.findByUsername(authentication.getName())
        .orElseThrow(() -> new UsuarioNotFoundException());

    return categoriaRepository.findById(gastoRequest.getIdCategoria())
        .map(categoria -> {
          Gasto gasto = new Gasto();
          gasto.setMonto(gastoRequest.getMonto());
          gasto.setDescripcion(gastoRequest.getDescripcion());
          gasto.setFechaGasto(gastoRequest.getFechaGasto());
          gasto.setMetodoPago(EnumMetodoPago.valueOf(gastoRequest.getMetodoPago()));
          gasto.setCategoria(categoria);
          gasto.setUsuario(usuario);
          return gastoRepository.save(gasto);
        }).map(gasto -> gastoMapper.toGastoResponse(gasto))
        .orElseThrow(() -> new CategoriaNotFoundException());
  }

}
