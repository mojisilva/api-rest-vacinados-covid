package com.mojisilva.apivacinadoscovid.dto.request;

import com.mojisilva.apivacinadoscovid.enums.NomeVacina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacinaDTO {

    private long id;

    @Enumerated(EnumType.STRING)
    private NomeVacina nome;

    @NotEmpty
    private String lote;

    @NotEmpty
    private int dose;

    @NotNull
    private String dataVacinacao;
}
