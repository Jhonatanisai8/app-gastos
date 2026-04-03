import { useState } from "react";
import { registrarUsuario } from "../service/usuarioService";

export const useRegistrarUsuario = () => {
  const [cargando, setCargando] = useState(false);
  const [error, setError] = useState(null);
  const [data, setData] = useState(null);

  const enviarSolicitud = async (usuarioData) => {
    setCargando(true);
    setError(null);
    try {
      const resultado = await registrarUsuario(usuarioData);
      setData(resultado);
      return resultado;
    } catch (error) {
      setError(error);
      throw error;
    } finally {
      setCargando(false);
    }
  };
  return { enviarSolicitud, cargando, error, data };
};
