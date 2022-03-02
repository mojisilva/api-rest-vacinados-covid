package com.apivacinadoscovid.services;

import com.apivacinadoscovid.dto.mapper.MapeadorVacinacao;
import com.apivacinadoscovid.dto.response.MensagemRespostaDTO;
import com.apivacinadoscovid.entity.Paciente;
import com.apivacinadoscovid.exceptions.PacienteNaoEncontrado;
import com.apivacinadoscovid.repository.RepositorioVacinacao;
import com.apivacinadoscovid.dto.request.PacienteDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServicoVacinacao {

    private final RepositorioVacinacao repositorioVacinacao;
    private final MapeadorVacinacao mapeadorVacinacao;

    @PostMapping
    public MensagemRespostaDTO registrarPaciente(@RequestBody PacienteDTO pacienteDTO){
        Paciente paciente = mapeadorVacinacao.toModel(pacienteDTO);
        Paciente pacienteRegistrado = repositorioVacinacao.save(paciente);
        MensagemRespostaDTO mensagemRespostaDTO = criarMensagemResposta("Registro do paciente salvo com sucesso ID: ", pacienteRegistrado.getId());
        return mensagemRespostaDTO;
    }

    public PacienteDTO buscarPaciente(Long id) throws PacienteNaoEncontrado {
        Paciente paciente = repositorioVacinacao.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontrado(id));
        return mapeadorVacinacao.toDTO(paciente);
    }

    public List<PacienteDTO> listarPacientes(){
        List<Paciente> pacientes = repositorioVacinacao.findAll();
        return pacientes.stream()
                .map(mapeadorVacinacao::toDTO)
                .collect(Collectors.toList());
    }

    public MensagemRespostaDTO atualizarPaciente(Long id, PacienteDTO pacienteDTO) throws PacienteNaoEncontrado{
        repositorioVacinacao.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontrado(id));
        Paciente pacienteAtualizado = mapeadorVacinacao.toModel(pacienteDTO);
        Paciente pacienteSalvo = repositorioVacinacao.save(pacienteAtualizado);
        MensagemRespostaDTO mensagemResposta = criarMensagemResposta("Paciente atualizado com sucesso ID ", pacienteSalvo.getId());
        return mensagemResposta;
    }

    public void deletarPaciente(Long id) throws PacienteNaoEncontrado{
        repositorioVacinacao.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontrado(id));
        repositorioVacinacao.deleteById(id);
    }

    private MensagemRespostaDTO criarMensagemResposta(String status, Long id){
        return MensagemRespostaDTO
                .builder()
                .mensagem(status + id)
                .build();
    }

}