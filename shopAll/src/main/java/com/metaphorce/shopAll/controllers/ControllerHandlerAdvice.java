package com.metaphorce.shopAll.controllers;

import com.metaphorce.shopAll.excepciones.DatosNoValidosException;
import com.metaphorce.shopAll.excepciones.PeliculaNoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerHandlerAdvice {

    @ExceptionHandler(DatosNoValidosException.class)
    public ResponseEntity <?> validacionEntradaDeDatos(DatosNoValidosException excepcion){
        Map<String, String> errores = new HashMap<>(); // List <String> errores = new ArrayList<>();
        // Recorremos la lista de los errores en result y lo pasamos por parametro
        excepcion.getBindingResult().getFieldErrors().forEach(fieldError -> errores.put(fieldError.getField() ,fieldError.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errores); // default '.body(null)' cambiamos a la lista
    }

    @ExceptionHandler(PeliculaNoEncontradaException.class)
    public ResponseEntity<?> peliculaNoEncontrada(PeliculaNoEncontradaException excepcion){
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Not Found");
        body.put("message", excepcion.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }

}
