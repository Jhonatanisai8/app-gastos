import React, { useState } from "react";
import "./RegisterExpense.css";

const CATEGORIES = [
  { id: "food", label: "Food", icon: "restaurant" },
  { id: "travel", label: "Travel", icon: "directions_car" },
  { id: "fun", label: "Fun", icon: "theater_comedy" },
  { id: "shopping", label: "Shopping", icon: "shopping_bag" },
  { id: "rent", label: "Rent", icon: "home" },
  { id: "health", label: "Health", icon: "medication" },
  { id: "bills", label: "Bills", icon: "bolt" },
  { id: "other", label: "Other", icon: "more_horiz" },
];

const RegisterExpense = () => {
  const [amount, setAmount] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("food");
  const [date, setDate] = useState(new Date().toISOString().split("T")[0]);
  const [note, setNote] = useState("");

  const handleSave = () => {
    const expense = {
      amount: parseFloat(amount),
      category: selectedCategory,
      date,
      note,
    };
    console.log("Saving expense:", expense);
    // Add save logic here (API call)
  };

  return (
    <div className="register-expense-container">
      {/* Header */}
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

      {/* Main Content */}
      <main className="expense-form">
        {/* Amount Input */}
        <section className="form-section amount-section">
          <label className="section-label">AMOUNT</label>
          <div className="amount-input-wrapper">
            <span className="currency-symbol">$</span>
            <input
              type="number"
              className="amount-input"
              placeholder="0.00"
              value={amount}
              onChange={(e) => setAmount(e.target.value)}
              autoFocus
            />
          </div>
        </section>

        {/* Category Selection */}
        <section className="form-section">
          <label className="section-label">CATEGORY</label>
          <div className="category-grid">
            {CATEGORIES.map((cat) => (
              <button
                key={cat.id}
                className={`category-item ${selectedCategory === cat.id ? "active" : ""}`}
                onClick={() => setSelectedCategory(cat.id)}
              >
                <span className="material-symbols-outlined">{cat.icon}</span>
                <span className="category-label">{cat.label}</span>
              </button>
            ))}
          </div>
        </section>

        {/* Date and Note */}
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

        {/* Info Cards (Bento Style) */}
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

      {/* Save Button */}
      <div className="action-button-container">
        <button className="primary-button" onClick={handleSave}>
          <span className="material-symbols-outlined">check</span>
          Guardar Gasto
        </button>
      </div>

      {/* Bottom Nav */}
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
