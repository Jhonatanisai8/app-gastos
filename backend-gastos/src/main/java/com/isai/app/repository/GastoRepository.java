package com.isai.app.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.isai.app.models.entities.Categoria;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isai.app.models.entities.Gasto;

@Repository
public interface GastoRepository extends CrudRepository<Gasto, Long> {
  List<Gasto> findAllByCategoria(Categoria categoria);

  @Query("SELECT COALESCE(SUM(g.monto), 0) FROM Gasto g WHERE g.usuario.idUsuario = :idUsuario")
  Optional<BigDecimal> sumByIdUsuario(Long idUsuario);
}
