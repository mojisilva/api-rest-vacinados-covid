package com.apivacinadoscovid.services;

import com.apivacinadoscovid.dto.mapper.MapeadorVacinacao;
import com.apivacinadoscovid.dto.request.VacinadoDTO;
import com.apivacinadoscovid.dto.response.MensagemResposta;
import com.apivacinadoscovid.entity.Vacinado;
import com.apivacinadoscovid.exceptions.RegistroNaoEncontrado;
import com.apivacinadoscovid.repository.RepositorioVacinacao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServicoVacinacao {

    private final RepositorioVacinacao repositorioVacinacao;
    private final MapeadorVacinacao mapeadorVacinacao;

     public MensagemResposta registrarVacinado(@RequestBody VacinadoDTO vacinadoDTO){
        Vacinado vacinado = mapeadorVacinacao.toModel(vacinadoDTO);
        Vacinado vacinadoRegistrado = repositorioVacinacao.save(vacinado);
        MensagemResposta mensagemResposta = criarMensagemResposta("Registro do vacinado salvo com sucesso ID: ", vacinadoRegistrado.getId());
        return mensagemResposta;
    }

    public VacinadoDTO buscarVacinado(Long id) throws RegistroNaoEncontrado {
        Vacinado vacinado = repositorioVacinacao.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontrado(id));
        return mapeadorVacinacao.toDTO(vacinado);
    }

    public List<VacinadoDTO> listarVacinados(){
        List<Vacinado> vacinados = repositorioVacinacao.findAll();
        return vacinados.stream()
                .map(mapeadorVacinacao::toDTO)
                .collect(Collectors.toList());
    }

    public MensagemResposta atualizarVacinados(Long id, VacinadoDTO vacinadoDTO) throws RegistroNaoEncontrado {
        repositorioVacinacao.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontrado(id));
        Vacinado vacinadoAtualizado = mapeadorVacinacao.toModel(vacinadoDTO);
        Vacinado vacinadoSalvo = repositorioVacinacao.save(vacinadoAtualizado);
        MensagemResposta mensagemResposta = criarMensagemResposta("Vacinado atualizado com sucesso ID ", vacinadoSalvo.getId());
        return mensagemResposta;
    }

    public void deletarVacinado(Long id) throws RegistroNaoEncontrado {
        repositorioVacinacao.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontrado(id));
        repositorioVacinacao.deleteById(id);
    }

    private MensagemResposta criarMensagemResposta(String status, Long id){
        return MensagemResposta
                .builder()
                .mensagem(status + id)
                .build();
    }

}