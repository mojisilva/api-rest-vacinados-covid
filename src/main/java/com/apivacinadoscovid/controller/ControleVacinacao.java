package com.apivacinadoscovid.controller;

import com.apivacinadoscovid.dto.response.MensagemRespostaDTO;
import com.apivacinadoscovid.dto.request.PacienteDTO;
import com.apivacinadoscovid.exceptions.PacienteNaoEncontrado;
import com.apivacinadoscovid.services.ServicoVacinacao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteDTO buscarPaciente(@PathVariable Long id) throws PacienteNaoEncontrado {
        return servicoVacinacao.buscarPaciente(id);
    }

    @GetMapping
    public List<PacienteDTO> listarPacientes(){
        return servicoVacinacao.listarPacientes();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MensagemRespostaDTO atualizarPaciente(@PathVariable Long id, @RequestBody @Valid PacienteDTO pacienteDTO) throws PacienteNaoEncontrado{
        return servicoVacinacao.atualizarPaciente(id, pacienteDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPaciente(@PathVariable Long id) throws PacienteNaoEncontrado{
        servicoVacinacao.deletarPaciente(id);
    }

}