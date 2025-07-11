package com.metaphorce.shopAll.excepciones;

import org.springframework.validation.BindingResult;

public class PeliculaNoEncontradaException extends RuntimeException {

    public PeliculaNoEncontradaException(String message) {
        super(message);
    }

}
