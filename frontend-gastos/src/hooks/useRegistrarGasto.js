import { useState } from "react";
import { registrarGasto } from "../service/gastoService";

export const useRegistrarGasto = () => {
  const [cargando, setCargando] = useState(false);
  const [error, setError] = useState(null);
  const [data, setData] = useState(null);
  const enviarSolicitud = async (gastoData) => {
    setCargando(true);
    setError(null);
    try {
      const resultado = await registrarGasto(gastoData);
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
