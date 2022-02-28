package com.apivacinadoscovid.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

    private long id;

    @NotEmpty
    @Size(min = 2, max = 120)
    private String nome;

    @NotNull
    private String telefone;

    @NotEmpty
    @CPF
    private String cpf;

    @NotNull
    private String aniversario;

    @Valid
    @NotEmpty
    private List<VacinaDTO> vacinas;
}
