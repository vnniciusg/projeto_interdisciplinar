package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence;

import br.com.projetointegrador.projetointegrador.application.ports.output.AtividadeOutputPort;
import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.AtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade.AtividadePersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.AtividadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
@RequiredArgsConstructor
public class AtividadePersistenceAdapter implements AtividadeOutputPort {

    private final AtividadeRepository atividadeRepository;
    private final AtividadePersistenceMapper atividadePersistenceMapper;
    @Override
    public Atividade save(Atividade atividade) {
        try {
            AtividadeEntity atividadeEntity = atividadePersistenceMapper.toAtividadeEntity(atividade);
            atividadeEntity = atividadeRepository.save(atividadeEntity);
            return atividadePersistenceMapper.toAtividade(atividadeEntity);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Erro ao salvar atividade : " + e.getMessage());
        }catch (Exception e){
            throw new RuntimeException("Algo inesperado ocorreu ao salvar atividade : " + e.getMessage());
        }

    }
    @Override
    public List<Atividade> list() {
        try{
            return atividadePersistenceMapper.toAtividades(atividadeRepository.findAll());
        }catch (Exception e){
            throw new RuntimeException("Algo inesperado ocorreu ao listar atividade : " + e.getMessage());
        }
    }

    @Override
    public Boolean delete(Long atividadId) {
        return null;
    }

    @Override
    public Boolean update(Atividade atividade) {
        return null;
    }
}
