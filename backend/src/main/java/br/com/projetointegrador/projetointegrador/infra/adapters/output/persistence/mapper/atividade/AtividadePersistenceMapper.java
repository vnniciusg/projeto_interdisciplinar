package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.AtividadeEntity;

import java.util.List;
import java.util.stream.Collectors;

public interface AtividadePersistenceMapper {
    Atividade toAtividade(AtividadeEntity atividadeEntity);

    List<Atividade> toAtividades(List<AtividadeEntity> atividadeEntities);
}
