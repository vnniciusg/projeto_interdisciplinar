package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.projeto;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.AtividadeEntity;

public interface AtividadePersistenceMapper {
    AtividadeEntity toAtividadeEntity(Atividade atividade);
    Atividade toAtividade(AtividadeEntity atividadeEntity);
}
