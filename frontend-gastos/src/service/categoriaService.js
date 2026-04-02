import { API_URL_BASE } from "../api/api";

export const listarCategorias = async () => {
  try {
    const response = await fetch(`${API_URL_BASE}/api/v1/categorias`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });
    const data = await response.json();
    console.log("PASO SERVICE");

    return data;
  } catch (error) {
    console.error("Error al listar categorías:", error);
    throw error;
  }
};
