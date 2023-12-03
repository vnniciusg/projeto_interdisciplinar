package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.AtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa.PessoaPersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.projeto.ProjetoPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AtividadePersistenceMapperImpl implements AtividadePersistenceMapper{

    private final PessoaPersistenceMapper pessoaPersistenceMapper;
    private final ProjetoPersistenceMapper projetoPersistenceMapper;

    @Override
    public Atividade toAtividade(AtividadeEntity atividadeEntity) {
        Atividade atividade = new Atividade();

        atividade.setaId(atividadeEntity.getAId());
        atividade.setaDescricao(atividadeEntity.getADescricao());
        atividade.setaTipo(atividadeEntity.getATipo());
        atividade.setaPessoaCadastra(pessoaPersistenceMapper.toPessoa(atividadeEntity.getAPessoaCadastra()));
        atividade.setaProjeto(projetoPersistenceMapper.toProjeto(atividadeEntity.getAProjeto()));

        return atividade;
    }

    @Override
    public List<Atividade> toAtividades(List<AtividadeEntity> atividadeEntities){
        return atividadeEntities.stream().map(this ::toAtividade ).collect(Collectors.toList());
    }
}
