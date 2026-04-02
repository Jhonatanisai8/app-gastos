import React, { useState, useEffect } from "react";
import "./RegisterExpense.css";
import { useListarCategorias } from "../hooks/useListarCategorias";

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
  const { categorias, cargando } = useListarCategorias();
  //para los campos
  const [formularioData, setFormularioData] = useState({
    monto: "",
    descripcion: "",
    fechaGasto: "",
    metodoPago: "",
    idCategoria: "",
  });

  // funcion para manejar los inputs
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormularioData({
      ...formularioData,
      [name]: value,
    });
  };
  useEffect(() => {
    if (categorias.length > 0 && !selectedCategoryId) {
      setSelectedCategoryId(categorias[0].idCategoria);
    }
  }, [categorias, selectedCategoryId]);

  const handleSave = () => {
    const expense = {
      monto: parseFloat(amount),
      idCategoria: selectedCategoryId,
      fechaGasto: date,
      descripcion: note,
      metodoPago: paymentMethod,
    };
    console.log("Saving expense:", expense);
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
        {/* input para el monto*/}
        <section className="form-section amount-section">
          <label className="section-label">AMOUNT</label>
          <div className="amount-input-wrapper">
            <span className="currency-symbol">$</span>
            <input
              type="number"
              className="amount-input"
              placeholder="0.00"
              value={formularioData.monto}
              onChange={(e) => setAmount(e.target.value)}
              autoFocus
            />
          </div>
        </section>

        <section className="form-section">
          <label className="section-label">CATEGORY</label>
          <div className="category-grid">
            {cargando ? (
              <div className="loading-categories">Cargando...</div>
            ) : (
              categorias.map((cat) => (
                <button
                  key={cat.idCategoria}
                  className={`category-item ${
                    selectedCategoryId === cat.idCategoria ? "active" : ""
                  }`}
                  onClick={() => setSelectedCategoryId(cat.idCategoria)}
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

        {/* seccion de metodos de pago */}
        <section className="form-section">
          <label className="section-label">PAYMENT METHOD</label>
          <div className="payment-grid">
            {PAYMENT_METHODS.map((pm) => (
              <button
                key={pm.id}
                className={`payment-item ${
                  paymentMethod === pm.id ? "active" : ""
                }`}
                onClick={() => setPaymentMethod(pm.id)}
              >
                <span className="material-symbols-outlined">{pm.icon}</span>
                <span className="payment-label">{pm.label}</span>
              </button>
            ))}
          </div>
        </section>

        {/* input para la fehca y la nota */}
        <div className="form-row">
          <section className="form-section half-width">
            <label className="section-label">DATE</label>
            <div className="input-field">
              <input
                type="date"
                className="input-control"
                value={date}
                onChange={(e) => setDate(e.target.value)}
              />
            </div>
          </section>
          <section className="form-section half-width">
            <label className="section-label">SHORT NOTE</label>
            <div className="input-field">
              <input
                type="text"
                className="input-control"
                placeholder="Lunch with colleagues"
                value={note}
                onChange={(e) => setNote(e.target.value)}
              />
            </div>
          </section>
        </div>

        {/* seccion de presupuesto y tendencias*/}
        <div className="info-cards">
          <div className="budget-card">
            <p className="card-label">MONTHLY BUDGET</p>
            <div className="budget-value-row">
              <span className="budget-amount">$2,450.00</span>
              <span className="budget-suffix">Left</span>
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
            <p className="trending-text">TRENDING HIGH</p>
          </div>
        </div>
      </main>

      {/* boton de guardar */}
      <div className="action-button-container">
        <button className="primary-button" onClick={handleSave}>
          <span className="material-symbols-outlined">check</span>
          Guardar Gasto
        </button>
      </div>

      {/* boton para ir a la pantalla de inicio */}
      <nav className="bottom-nav">
        <button className="nav-item">
          <span className="material-symbols-outlined">home</span>
          <span>Home</span>
        </button>
        <button className="nav-item active">
          <span
            className="material-symbols-outlined"
            style={{ fontVariationSettings: "'FILL' 1" }}
          >
            add_circle
          </span>
          <span>Add</span>
        </button>
        <button className="nav-item">
          <span className="material-symbols-outlined">history</span>
          <span>History</span>
        </button>
      </nav>
    </div>
  );
};

export default RegisterExpense;
