package com.isai.app.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.isai.app.exceptions.CategoriaExistenteException;
import com.isai.app.exceptions.CategoriaNotFoundException;
import com.isai.app.exceptions.ErrorResponse;
import com.isai.app.exceptions.UsuarioNotFoundException;
import com.isai.app.utils.ErrorCatalago;

@RestControllerAdvice
public class GlobalControllerAdvice {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorResponse handlerMethodArgumentNotValidException(
      MethodArgumentNotValidException argumentNoValido) {
    BindingResult bindingResult = argumentNoValido.getBindingResult();
    return ErrorResponse.builder()
        .codigo(ErrorCatalago.DATOS_INVALIDOS.getCodigo())
        .httpEstado(HttpStatus.BAD_REQUEST.name())
        .mensaje(ErrorCatalago.DATOS_INVALIDOS.getMensaje())
        .detallesMensajes(bindingResult.getFieldErrors().stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .toList())
        .fechaHora(LocalDateTime.now())
        .build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(CategoriaExistenteException.class)
  public ErrorResponse handlerCategoriaExistenteException(
      CategoriaExistenteException existeeException) {
    return ErrorResponse.builder()
        .codigo(ErrorCatalago.CATEGORIA_EXISTENTE.getCodigo())
        .httpEstado(HttpStatus.BAD_REQUEST.name())
        .mensaje(ErrorCatalago.CATEGORIA_EXISTENTE.getMensaje())
        .fechaHora(LocalDateTime.now())
        .build();
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(UsuarioNotFoundException.class)
  public ErrorResponse handlerUsuarioNotFoundException(
      UsuarioNotFoundException notFoundException) {
    return ErrorResponse.builder()
        .codigo(ErrorCatalago.USUARIO_NOT_FOUND.getCodigo())
        .httpEstado(HttpStatus.NOT_FOUND.name())
        .mensaje(ErrorCatalago.USUARIO_NOT_FOUND.getMensaje())
        .fechaHora(LocalDateTime.now())
        .build();
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(CategoriaNotFoundException.class)
  public ErrorResponse handlerCategoriaNotFoundException(
      CategoriaNotFoundException notFoundException) {
    return ErrorResponse.builder()
        .codigo(ErrorCatalago.CATEGORIA_NOT_FOUND.getCodigo())
        .httpEstado(HttpStatus.NOT_FOUND.name())
        .mensaje(ErrorCatalago.CATEGORIA_NOT_FOUND.getMensaje())
        .fechaHora(LocalDateTime.now())
        .build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ErrorResponse handlerHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
    return ErrorResponse.builder()
        .codigo(ErrorCatalago.DATOS_INVALIDOS.getCodigo())
        .mensaje("Error en el formato del JSON: El tipo de dato es incorrecto")
        .httpEstado(HttpStatus.BAD_REQUEST.name())
        .fechaHora(LocalDateTime.now())
        .build();
  }

}
