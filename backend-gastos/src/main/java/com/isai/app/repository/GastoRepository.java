package com.isai.app.repository;

import java.util.List;

import com.isai.app.models.entities.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isai.app.models.entities.Gasto;

@Repository
public interface GastoRepository extends CrudRepository<Gasto, Long> {
    List<Gasto> findAllByCategoria(Categoria categoria);
}
