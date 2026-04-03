import React, { useState } from "react";
import "./RegistroUsuario.css";
import { Link, useNavigate } from "react-router-dom";
import { useRegistrarUsuario } from "../../hooks/useRegistrarUsuario";

const RegistroUsuario = () => {
  const [formularioData, setFormularioData] = useState({
    username: "",
    password: "",
    nombres: "",
    apellidos: "",
    ciudad: "",
  });
  const { enviarSolicitud, cargando, error, data } = useRegistrarUsuario();
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormularioData({
      ...formularioData,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const resultado = await enviarSolicitud(formularioData);
    if (resultado) {
      alert("Usuario registrado exitosamente");
      setFormularioData({
        username: "",
        password: "",
        nombres: "",
        apellidos: "",
        ciudad: "",
      });
      navigate("/");
    }
  };

  return (
    <div className="auth-container">
      <div className="auth-card">
        {/* header */}
        <div className="auth-header">
          <span className="material-symbols-outlined auth-logo-icon">
            account_balance_wallet
          </span>
          <span className="auth-brand">Mis Finanzas App</span>
        </div>

        {/* seccion de bienvenida */}
        <div className="auth-welcome-section">
          <h1 className="auth-title">Crea tu cuenta</h1>
          <p className="auth-subtitle">
            Regístrate para gestionar tus gastos y ahorros
          </p>
        </div>
        <form onSubmit={handleSubmit}>
          {/* area del formulario */}
          <div className="auth-form">
            <div className="auth-form-row">
              <section className="form-section half-width">
                <label className="auth-section-label">Nombres</label>
                <div className="auth-input-field">
                  <input
                    type="text"
                    className="auth-input-control"
                    placeholder="Ej. Jhonatan"
                    value={formularioData.nombres}
                    onChange={handleChange}
                    name="nombres"
                    disabled={cargando}
                  />
                </div>
              </section>
              <section className="form-section half-width">
                <label className="auth-section-label">Apellidos</label>
                <div className="auth-input-field">
                  <input
                    type="text"
                    className="auth-input-control"
                    placeholder="Ej. Pérez"
                    value={formularioData.apellidos}
                    onChange={handleChange}
                    name="apellidos"
                    disabled={cargando}
                  />
                </div>
              </section>
            </div>

            <section className="form-section">
              <label className="auth-section-label">Username</label>
              <div className="auth-input-field">
                <input
                  type="text"
                  className="auth-input-control"
                  placeholder="@isai_dev"
                  value={formularioData.username}
                  onChange={handleChange}
                  name="username"
                  disabled={cargando}
                />
              </div>
            </section>

            <section className="form-section">
              <label className="auth-section-label">Ciudad</label>
              <div className="auth-input-field">
                <input
                  type="text"
                  className="auth-input-control"
                  placeholder="Ej. Lima"
                  value={formularioData.ciudad}
                  onChange={handleChange}
                  name="ciudad"
                  disabled={cargando}
                />
              </div>
            </section>

            <section className="form-section">
              <label className="auth-section-label">Password</label>
              <div className="auth-input-field">
                <input
                  type="password"
                  className="auth-input-control"
                  placeholder="••••••••••••"
                  value={formularioData.password}
                  onChange={handleChange}
                  name="password"
                  disabled={cargando}
                />
              </div>
            </section>

            {/* boton de accion */}
            <button
              className="auth-action-button"
              type="submit"
              disabled={cargando}
            >
              {cargando ? "Registrando..." : "Registrarse"}
              <span className="material-symbols-outlined">arrow_forward</span>
            </button>
          </div>
        </form>
        {error && <p style={{ color: "red" }}>Error: {error}</p>}
        {/* enlace del footer */}
        <div className="auth-footer-link">
          <Link to="/login" className="auth-link">
            ¿Ya tienes cuenta? Inicia sesión
            <span className="material-symbols-outlined">chevron_right</span>
          </Link>
        </div>
      </div>

      <p className="auth-copyright">
        © {new Date().getFullYear()} MI FINANZAS APP
      </p>
    </div>
  );
};

export default RegistroUsuario;
