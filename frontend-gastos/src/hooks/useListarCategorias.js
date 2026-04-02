import { useEffect, useState } from "react";
import { listarCategorias } from "../service/categoriaService";

export const useListarCategorias = () => {
  const [categorias, setCategorias] = useState([]);

  const [cargando, setCargando] = useState(true);
  const [error, setError] = useState(null);
  useEffect(() => {
    listarCategorias()
      .then((data) => {
        setCategorias(data);
        setCargando(false);
      })
      .catch((error) => {
        setError(error);
        setCargando(false);
      });
  }, []);
  console.log("PASO CUSTOM HOOK");
  
  return { categorias, cargando, error };
};
