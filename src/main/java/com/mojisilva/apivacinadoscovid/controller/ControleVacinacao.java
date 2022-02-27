package com.mojisilva.apivacinadoscovid.controller;

import com.mojisilva.apivacinadoscovid.dto.MensagemRespostaDTO;
import com.mojisilva.apivacinadoscovid.entity.Paciente;
import com.mojisilva.apivacinadoscovid.repository.RepositorioVacinacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vaccine")
public class ControleVacinacao {

    private RepositorioVacinacao repositorioVacinacao;

    @Autowired
    public ControleVacinacao(RepositorioVacinacao repositorioVacinacao) {
        this.repositorioVacinacao = repositorioVacinacao;
    }

    @PostMapping
    public MensagemRespostaDTO criarPaciente(@RequestBody Paciente paciente){
        Paciente pacienteSalvo = repositorioVacinacao.save(paciente);
        return MensagemRespostaDTO
                .builder()
                .mensagem("Resgistro do paciente salvo com sucesso ID " + pacienteSalvo.getId())
                .build();

    }


}
