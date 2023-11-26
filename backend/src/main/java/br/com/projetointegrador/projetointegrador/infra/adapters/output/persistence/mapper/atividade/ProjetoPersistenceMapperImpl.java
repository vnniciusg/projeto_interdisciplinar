package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade;

import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjetoPersistenceMapperImpl implements ProjetoPersistenceMapper {

    private final ModelMapper modelMapper;
    @Override
    public ProjetoEntity toProjetoEntity(Projeto projeto) {
        return modelMapper.map(projeto, ProjetoEntity.class);
    }
    @Override
    public Projeto toProjeto(ProjetoEntity projetoEntity) {
        return modelMapper.map(projetoEntity , Projeto.class);
    }
}
