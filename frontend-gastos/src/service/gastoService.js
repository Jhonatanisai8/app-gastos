import { API_URL_BASE } from "../api/api";

export const registrarGasto = async (gastoData) => {
  try {
    const renponse = await fetch(`${API_URL_BASE}/api/v1/gastos`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(gastoData),
    });
    if (!renponse.ok) {
      throw new Error("Error al registrar el gasto");
    }
    return await renponse.json();
  } catch (error) {
    console.error("Error al registrar el gasto:", error);
    throw error;
  }
};
