package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.AtividadeEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AtividadePersistenceMapperImpl implements AtividadePersistenceMapper{

    private final ModelMapper modelMapper;
    @Override
    public AtividadeEntity toAtividadeEntity(Atividade atividade) {
        return modelMapper.map(atividade, AtividadeEntity.class);
    }

    @Override
    public Atividade toAtividade(AtividadeEntity atividadeEntity) {
        return modelMapper.map(atividadeEntity, Atividade.class);
    }

    @Override
    public List<Atividade> toAtividades(List<AtividadeEntity> atividadeEntities){
        return atividadeEntities.stream().map(this ::toAtividade ).collect(Collectors.toList());
    }
}
