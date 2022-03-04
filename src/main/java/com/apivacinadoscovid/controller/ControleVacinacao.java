package com.apivacinadoscovid.controller;

import com.apivacinadoscovid.dto.response.MensagemResposta;
import com.apivacinadoscovid.dto.request.VacinadoDTO;
import com.apivacinadoscovid.exceptions.RegistroNaoEncontrado;
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
    public MensagemResposta registrarVacinado(@RequestBody @Valid VacinadoDTO vacinadoDTO){
        return servicoVacinacao.registrarVacinado(vacinadoDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VacinadoDTO buscarVacinado(@PathVariable Long id) throws RegistroNaoEncontrado {
        return servicoVacinacao.buscarVacinado(id);
    }

    @GetMapping
    public List<VacinadoDTO> listarVacinado(){
        return servicoVacinacao.listarVacinados();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MensagemResposta atualizarVacinado(@PathVariable Long id, @RequestBody @Valid VacinadoDTO vacinadoDTO) throws RegistroNaoEncontrado {
        return servicoVacinacao.atualizarVacinados(id, vacinadoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarVacinado(@PathVariable Long id) throws RegistroNaoEncontrado {
        servicoVacinacao.deletarVacinado(id);
    }

}