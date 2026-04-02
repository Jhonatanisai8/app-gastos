import React, { useState, useEffect } from "react";
import "./RegisterExpense.css";
import { useListarCategorias } from "../hooks/useListarCategorias";
import { useRegistrarGasto } from "../hooks/useRegistrarGasto";

const ICON_MAP = {
  Food: "restaurant",
  Comida: "restaurant",
  Travel: "directions_car",
  Viaje: "directions_car",
  Fun: "theater_comedy",
  Diversión: "theater_comedy",
  Shopping: "shopping_bag",
  Compras: "shopping_bag",
  Rent: "home",
  Renta: "home",
  Health: "medication",
  Salud: "medication",
  Bills: "bolt",
  Servicios: "bolt",
  Other: "more_horiz",
  Otros: "more_horiz",
};

const PAYMENT_METHODS = [
  { id: "EFECTIVO", label: "Efectivo", icon: "payments" },
  { id: "TARJETA_DEBITO", label: "Débito", icon: "credit_card" },
  { id: "TARJETA_CREDITO", label: "Crédito", icon: "credit_card" },
  { id: "TRANSFERENCIA_BANCARIA", label: "Transf.", icon: "account_balance" },
  { id: "PAYPAL", label: "Paypal", icon: "account_balance_wallet" },
  { id: "OTRO", label: "Otro", icon: "help_outline" },
];

const RegisterExpense = () => {
  const { categorias, cargando: cargandoCategorias } = useListarCategorias();
  const {
    enviarSolicitud,
    cargando: registrando,
    error,
    data,
  } = useRegistrarGasto();

  const [formularioData, setFormularioData] = useState({
    monto: "",
    descripcion: "",
    fechaGasto: new Date().toISOString().split("T")[0],
    metodoPago: "EFECTIVO",
    idCategoria: "",
  });

  const [mensajeExito, setMensajeExito] = useState(null);

  // se inicializa la categoria por defecto
  useEffect(() => {
    if (categorias?.length > 0 && !formularioData.idCategoria) {
      setFormularioData((prev) => ({
        ...prev,
        idCategoria: categorias[0].idCategoria,
      }));
    }
  }, [categorias, formularioData.idCategoria]);

  // metodos handlers
  const manejarCambio = (e) => {
    const { name, value } = e.target;
    setFormularioData({ ...formularioData, [name]: value });
  };

  const seleccionarCategoria = (id) => {
    setFormularioData({ ...formularioData, idCategoria: id });
  };

  const seleccionarMetodo = (id) => {
    setFormularioData({ ...formularioData, metodoPago: id });
  };

  const guardarGasto = async () => {
    // Validación básica
    if (!formularioData.monto || parseFloat(formularioData.monto) <= 0) {
      alert("Por favor ingresa un monto válido");
      return;
    }

    try {
      const gastaAEnviar = {
        ...formularioData,
        monto: parseFloat(formularioData.monto),
      };

      await enviarSolicitud(gastaAEnviar);
      setMensajeExito("¡Gasto registrado con éxito!");

      // Limpiar formulario excepto categoría y método por defecto
      setTimeout(() => {
        setFormularioData((prev) => ({
          ...prev,
          monto: "",
          descripcion: "",
          fechaGasto: new Date().toISOString().split("T")[0],
        }));
        setMensajeExito(null);
      }, 2000);
    } catch (err) {
      console.error("Error al guardar:", err);
    }
  };

  return (
    <div className="register-expense-container">
      <header className="app-header">
        <div className="header-left">
          <span className="material-symbols-outlined logo-icon">
            account_balance_wallet
          </span>
          <h1 className="header-title">Finance Tracker</h1>
        </div>
        <button className="header-menu-btn">
          <span className="material-symbols-outlined">more_vert</span>
        </button>
      </header>

      <main className="expense-form">
        {/* Sección de Mensajes */}
        {error && (
          <div className="error-message">
            Error: {error.message || "No se pudo registrar"}
          </div>
        )}
        {mensajeExito && <div className="success-message">{mensajeExito}</div>}

        {/* Input para el monto */}
        <section className="form-section amount-section">
          <label className="section-label">MONTO</label>
          <div className="amount-input-wrapper">
            <span className="currency-symbol">$</span>
            <input
              name="monto"
              type="number"
              className="amount-input"
              placeholder="0.00"
              value={formularioData.monto}
              onChange={manejarCambio}
              autoFocus
            />
          </div>
        </section>

        {/* Sección de Categorías */}
        <section className="form-section">
          <label className="section-label">CATEGORÍA</label>
          <div className="category-grid">
            {cargandoCategorias ? (
              <div className="loading-categories">Cargando categorías...</div>
            ) : (
              categorias.map((cat) => (
                <button
                  key={cat.idCategoria}
                  className={`category-item ${formularioData.idCategoria === cat.idCategoria ? "active" : ""}`}
                  onClick={() => seleccionarCategoria(cat.idCategoria)}
                >
                  <span className="material-symbols-outlined">
                    {ICON_MAP[cat.nombre] || "category"}
                  </span>
                  <span className="category-label">{cat.nombre}</span>
                </button>
              ))
            )}
          </div>
        </section>

        {/* Sección de Métodos de Pago */}
        <section className="form-section">
          <label className="section-label">MÉTODO DE PAGO</label>
          <div className="payment-grid">
            {PAYMENT_METHODS.map((pm) => (
              <button
                key={pm.id}
                className={`payment-item ${formularioData.metodoPago === pm.id ? "active" : ""}`}
                onClick={() => seleccionarMetodo(pm.id)}
              >
                <span className="material-symbols-outlined">{pm.icon}</span>
                <span className="payment-label">{pm.label}</span>
              </button>
            ))}
          </div>
        </section>

        {/* Fecha y Nota */}
        <div className="form-row">
          <section className="form-section half-width">
            <label className="section-label">FECHA</label>
            <div className="input-field">
              <input
                name="fechaGasto"
                type="date"
                className="input-control"
                value={formularioData.fechaGasto}
                onChange={manejarCambio}
              />
            </div>
          </section>
          <section className="form-section half-width">
            <label className="section-label">NOTA CORTA</label>
            <div className="input-field">
              <input
                name="descripcion"
                type="text"
                className="input-control"
                placeholder="Ej. Almuerzo del lunes"
                value={formularioData.descripcion}
                onChange={manejarCambio}
              />
            </div>
          </section>
        </div>

        {/* Sección Bento (Informativa) */}
        <div className="info-cards">
          <div className="budget-card">
            <p className="card-label">PRESUPUESTO MENSUAL</p>
            <div className="budget-value-row">
              <span className="budget-amount">$2,450.00</span>
              <span className="budget-suffix">Restante</span>
            </div>
            <div className="budget-progress-bg">
              <div
                className="budget-progress-bar"
                style={{ width: "66%" }}
              ></div>
            </div>
          </div>
          <div className="trending-card">
            <span className="material-symbols-outlined trending-icon">
              trending_up
            </span>
            <p className="trending-text">ALTO CONSUMO</p>
          </div>
        </div>
      </main>

      {/* Botón de Guardar */}
      <div className="action-button-container">
        <button
          className={`primary-button ${registrando ? "loading" : ""}`}
          onClick={guardarGasto}
          disabled={registrando}
        >
          <span className="material-symbols-outlined">
            {registrando ? "sync" : "check"}
          </span>
          {registrando ? "Guardando..." : "Guardar Gasto"}
        </button>
      </div>

      {/* Navegación Inferior */}
      <nav className="bottom-nav">
        <button className="nav-item">
          <span className="material-symbols-outlined">home</span>
          <span>Inicio</span>
        </button>
        <button className="nav-item active">
          <span
            className="material-symbols-outlined"
            style={{ fontVariationSettings: "'FILL' 1" }}
          >
            add_circle
          </span>
          <span>Añadir</span>
        </button>
        <button className="nav-item">
          <span className="material-symbols-outlined">history</span>
          <span>Historial</span>
        </button>
      </nav>
    </div>
  );
};

export default RegisterExpense;
