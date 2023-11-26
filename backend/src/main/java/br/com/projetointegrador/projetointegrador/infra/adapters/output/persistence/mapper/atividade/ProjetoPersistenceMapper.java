package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade;

import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;

public interface ProjetoPersistenceMapper {
    ProjetoEntity toProjetoEntity(Projeto projeto);
    Projeto toProjeto(ProjetoEntity projetoEntity);

}
