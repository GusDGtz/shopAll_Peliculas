package com.metaphorce.shopAll.excepciones;

import org.springframework.validation.BindingResult;

public class DatosNoValidosException extends RuntimeException {
    // ATRIBUTOS
    BindingResult bindingResult;

    // CONSTRUCTOR
    public DatosNoValidosException(String message, BindingResult bindingResult) {
        super(message);
        this.bindingResult = bindingResult;
    }

    // GET-SET
    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
