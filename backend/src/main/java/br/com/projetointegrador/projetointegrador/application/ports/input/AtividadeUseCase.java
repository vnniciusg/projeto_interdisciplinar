package br.com.projetointegrador.projetointegrador.application.ports.input;

 import br.com.projetointegrador.projetointegrador.application.dto.atividade.request.CriarAtividadeRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;

import java.util.List;

public interface AtividadeUseCase {
    Atividade criarAtividade(CriarAtividadeRequestDTO requestDTO);
    List<Atividade> listarAtividades();

    List<Atividade> listarAtividadesPorPessoaCadastra(Long id);
    Boolean deletarAtividade(Long atividadeId);
    Boolean atualizarAtividade(Atividade atividade);
}
