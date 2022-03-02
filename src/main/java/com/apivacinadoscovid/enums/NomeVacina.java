package com.apivacinadoscovid.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NomeVacina {

    CORONAVAC("Coronavac"),
    JANSSEN("Janssen"),
    OXFORD("Oxford"),
    PFIZER("Pfizer");

    private final String descricao;

}