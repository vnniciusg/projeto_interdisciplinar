package br.com.projetointegrador.projetointegrador.application.ports.input;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade;

import java.util.List;
import java.util.UUID;

public interface AtividadeUseCase {
    Atividade criarAtividade(Atividade atividade);
    List<Atividade> listarAtividades();
    Boolean deletarAtividade(UUID atividade_ID);

    Boolean atualizarAtividade(UUID atividade_ID, Atividade atividade);
}
