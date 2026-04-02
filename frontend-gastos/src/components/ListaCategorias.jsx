import React from "react";
import { useListarCategorias } from "../hooks/useListarCategorias";

const ListaCategorias = () => {
  const { categorias, cargando, error } = useListarCategorias();
  if (cargando) {
    return <div>Cargando categorías...</div>;
  }
  if (error) {
    return <div>Error al cargar categorías: {error.message}</div>;
  }
  console.log("PASE COMPONENTE");
  
  return (
    <div>
      <h2>Lista de Categorías</h2>
      <ul>
        {categorias.map((categoria) => (
          <li key={categoria.idCategoria}>{categoria.nombre}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListaCategorias;
