package com.apivacinadoscovid.services;

import com.apivacinadoscovid.dto.mapper.MapeadorVacinacao;
import com.apivacinadoscovid.dto.response.MensagemRespostaDTO;
import com.apivacinadoscovid.entity.Paciente;
import com.apivacinadoscovid.repository.RepositorioVacinacao;
import com.apivacinadoscovid.dto.request.PacienteDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServicoVacinacao {

    private final RepositorioVacinacao repositorioVacinacao;
    private final MapeadorVacinacao mapeadorVacinacao;

    @PostMapping
    public MensagemRespostaDTO criarPaciente(@RequestBody PacienteDTO pacienteDTO){
        Paciente paciente = mapeadorVacinacao.toModel(pacienteDTO);
        Paciente pacienteRegistrado = repositorioVacinacao.save(paciente);
        MensagemRespostaDTO mensagemRespostaDTO = criarMensagemResposta("Registro do paciente salvo com sucesso ID: ", pacienteRegistrado.getId());
        return mensagemRespostaDTO;
    }

    private MensagemRespostaDTO criarMensagemResposta(String status, Long id){
        return MensagemRespostaDTO
                .builder()
                .mensagem(status + id)
                .build();
    }

}