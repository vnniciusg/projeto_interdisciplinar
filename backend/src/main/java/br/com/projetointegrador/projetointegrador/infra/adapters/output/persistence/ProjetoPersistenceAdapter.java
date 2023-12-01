package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence;

import br.com.projetointegrador.projetointegrador.application.ports.output.ProjetoOutputPort;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.projeto.ProjetoPersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@RequiredArgsConstructor
public class ProjetoPersistenceAdapter implements ProjetoOutputPort {

    private final ProjetoRepository projetoRepository;
    private final ProjetoPersistenceMapper projetoPersistenceMapper;
    @Override
    public Projeto save(Projeto projeto) {
        try{
            ProjetoEntity projetoEntity = projetoPersistenceMapper.toProjetoEntity(projeto);
            projetoEntity = projetoRepository.save(projetoEntity);
            return projetoPersistenceMapper.toProjeto(projetoEntity);
        }catch(DataIntegrityViolationException e){
            throw new RuntimeException("Erro ao salvar projeto : " + e.getMessage());
        }catch (Exception e){
            throw new RuntimeException("Algo inesperado ocorreu ao salvar o projeto " + e.getMessage());
        }
    }

    @Override
    public List<Projeto> list() {
        try{
            return projetoPersistenceMapper.toProjetos(projetoRepository.findAll());
        }catch (Exception e){
            throw new RuntimeException("Algo inesperado ocorreu ao listar projetos : "  + e.getMessage());
        }

    }

    @Override
    public Boolean delete(Long projetoId) {
        try{
            return true;
        }catch(Exception e){
            throw new RuntimeException("Algo inesperado ocorreu ao deletar projeto " + projetoId + " : "  + e.getMessage());
        }

    }

    @Override
    public Boolean update(Projeto projeto) {
        return null;
    }

}
