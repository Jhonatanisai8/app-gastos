package com.isai.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isai.app.models.entities.Categoria;

@Repository
public interface CategoriaRepository
        extends CrudRepository<Categoria, Long> {

    boolean existsByNombre(String nombre);
}
