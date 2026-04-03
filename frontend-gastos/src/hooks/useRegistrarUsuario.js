import { useState } from "react";
import { registrarUsuario } from "../service/usuarioService";
import { authStorage } from "../utils/authStorage";

export const useRegistrarUsuario = () => {
  const [cargando, setCargando] = useState(false);
  const [error, setError] = useState(null);
  const [data, setData] = useState(null);

  const enviarSolicitud = async (usuarioData) => {
    setCargando(true);
    setError(null);
    try {
      const resultado = await registrarUsuario(usuarioData);
      if (resultado && resultado.token) {
        authStorage.setToken(resultado.token);
      }
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
