package com.isai.app.utils;

public enum ErrorCatalago {
    CATEGORIA_INVALIDA("CATEGORIA_INVALIDA", "La categoría proporcionada no es válida"),
    CATEGORIA_EXISTENTE("CATEGORIA_EXISTENTE", "La categoría ya existe"),
    CATEGORIA_NOT_FOUND("CATEGORIA_NOT_FOUND", "Categoria no encontrada"),
    USUARIO_NOT_FOUND("USUARIO_NOT_FOUND", "Usuario no encontrado"),
    DATOS_INVALIDOS("VAL-001", "La solicitud contiene datos inválidos"),
    ERROR_INTERNO("ERROR_INTERNO", "Error interno del servidor");

    private final String codigo;
    private final String mensaje;

    ErrorCatalago(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }
}
