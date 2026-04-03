import { API_URL_BASE } from "../api/api";

export const registrarUsuario = async (usuarioData) => {
  try {
    const response = await fetch(`${API_URL_BASE}/api/v1/auth/registro`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(usuarioData),
    });
    if (!response.ok) {
      throw new Error("Error al registrar el usuario");
    }
    return await response.json();
  } catch (error) {
    console.error("Error al registrar el usuario:", error);
    throw error;
  }
};
