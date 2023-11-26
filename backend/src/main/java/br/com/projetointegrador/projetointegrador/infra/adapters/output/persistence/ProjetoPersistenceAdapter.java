package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence;

import br.com.projetointegrador.projetointegrador.application.ports.output.ProjetoOutputPort;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade.ProjetoPersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ProjetoPersistenceAdapter implements ProjetoOutputPort {

    private final ProjetoRepository projetoRepository;
    private final ProjetoPersistenceMapper projetoPersistenceMapper;
    @Override
    public Projeto save(Projeto projeto) {
        ProjetoEntity projetoEntity = projetoPersistenceMapper.toProjetoEntity(projeto);
        projetoEntity = projetoRepository.save(projetoEntity);
        return projetoPersistenceMapper.toProjeto(projetoEntity);
    }

    @Override
    public List<Projeto> list() {
        return null;
    }

    @Override
    public Boolean delete(UUID projeto_ID) {
        return null;
    }

    @Override
    public Boolean update(UUID projeto_ID, Projeto projeto) {
        return null;
    }
}
