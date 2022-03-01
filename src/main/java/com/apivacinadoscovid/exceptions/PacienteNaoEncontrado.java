package com.apivacinadoscovid.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PacienteNaoEncontrado extends Exception {

    public PacienteNaoEncontrado(Long id){
        super(String.format("Paciente %s não enconytrado", id));
    }

}
