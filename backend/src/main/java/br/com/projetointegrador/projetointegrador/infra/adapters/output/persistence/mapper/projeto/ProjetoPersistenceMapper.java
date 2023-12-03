package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.projeto;

import br.com.projetointegrador.projetointegrador.domain.dto.CriarProjetoRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;

import java.util.List;

public interface ProjetoPersistenceMapper {
    ProjetoEntity toProjetoEntity(CriarProjetoRequestDTO criarProjetoRequestDTO);
    Projeto toProjeto(ProjetoEntity projetoEntity);

    List<Projeto> toProjetos(List<ProjetoEntity> projetosEntity);

}
