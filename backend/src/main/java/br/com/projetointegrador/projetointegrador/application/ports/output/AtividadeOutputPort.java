package br.com.projetointegrador.projetointegrador.application.ports.output;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;

import java.util.List;
import java.util.UUID;

public interface AtividadeOutputPort {
    Atividade save(Atividade atividade);
    List<Atividade> list();
    Boolean delete(Long atividadId);
    Boolean update(Atividade atividade);
}
