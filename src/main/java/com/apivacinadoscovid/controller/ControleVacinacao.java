package com.apivacinadoscovid.controller;

import com.apivacinadoscovid.dto.response.MensagemRespostaDTO;
import com.apivacinadoscovid.dto.request.PacienteDTO;
import com.apivacinadoscovid.services.ServicoVacinacao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/vaccine")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ControleVacinacao {

    private final ServicoVacinacao servicoVacinacao;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemRespostaDTO criarPaciente(@RequestBody @Valid PacienteDTO pacienteDTO){
        return servicoVacinacao.registrarPaciente(pacienteDTO);
    }

}
