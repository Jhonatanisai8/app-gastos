import { useState } from "react";
import "./App.css";
import RegisterExpense from "./components/RegisterExpense";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import RegistroUsuario from "./components/auth/RegistroUsuario";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/registrar-gasto" element={<RegisterExpense />} />
          <Route path="/registrar-usuario" element={<RegistroUsuario />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
