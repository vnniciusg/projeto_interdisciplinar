package br.com.projetointegrador.projetointegrador.application.ports.output;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade;

import java.util.List;
import java.util.UUID;

public interface AtividadeOutputPort {
    Atividade save(Atividade atividade);
    List<Atividade> list();
    Boolean delete(UUID atividade_ID);

    Boolean update(UUID atividade_ID , Atividade atividade);
}
