package com.apivacinadoscovid.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegistroNaoEncontrado extends Exception {

    public RegistroNaoEncontrado(Long id){
        super(String.format("Registro %s não encontrado", id));
    }

}