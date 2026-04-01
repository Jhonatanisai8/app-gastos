package com.isai.app.service;

import java.util.Set;

import com.isai.app.models.dtos.req.CategoriaRequest;
import com.isai.app.models.dtos.res.CategoriaResponse;

public interface CategoriaService {
    CategoriaResponse guardarCategoria(CategoriaRequest categoriaRequest);

    Set<CategoriaResponse> obtenerTodasLasCategorias();
}
