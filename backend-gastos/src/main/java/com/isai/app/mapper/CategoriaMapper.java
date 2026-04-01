package com.isai.app.mapper;

import org.mapstruct.Mapper;

import com.isai.app.models.dtos.req.CategoriaRequest;
import com.isai.app.models.dtos.res.CategoriaResponse;
import com.isai.app.models.entities.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
  CategoriaResponse toCategoriaResponse(Categoria categoria);

  Categoria toCategoria(CategoriaRequest categoriaRequest);
}
