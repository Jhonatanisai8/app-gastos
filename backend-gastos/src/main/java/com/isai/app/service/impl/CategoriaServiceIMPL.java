package com.isai.app.service.impl;

import org.springframework.stereotype.Service;

import com.isai.app.mapper.CategoriaMapper;
import com.isai.app.models.dtos.CategoriaRequest;
import com.isai.app.models.dtos.CategoriaResponse;
import com.isai.app.models.entities.Categoria;
import com.isai.app.repository.CategoriaRepository;
import com.isai.app.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceIMPL implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public CategoriaResponse guardarCategoria(CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaMapper.toCategoria(categoriaRequest);
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return categoriaMapper.toCategoriaResponse(savedCategoria);
    }

}
