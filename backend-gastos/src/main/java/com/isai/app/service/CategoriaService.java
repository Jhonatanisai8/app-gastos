package com.isai.app.service;

import com.isai.app.models.dtos.CategoriaRequest;
import com.isai.app.models.dtos.CategoriaResponse;

public interface CategoriaService {
    CategoriaResponse guardarCategoria(CategoriaRequest categoriaRequest);
}
