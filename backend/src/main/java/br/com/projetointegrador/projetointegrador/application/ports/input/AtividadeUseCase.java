package br.com.projetointegrador.projetointegrador.application.ports.input;

import br.com.projetointegrador.projetointegrador.domain.dto.CriarAtividadeRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;

import java.util.List;
import java.util.UUID;

public interface AtividadeUseCase {
    Atividade criarAtividade(CriarAtividadeRequestDTO requestDTO);
    List<Atividade> listarAtividades();
    Boolean deletarAtividade(Long atividadeId);
    Boolean atualizarAtividade(Atividade atividade);
}
