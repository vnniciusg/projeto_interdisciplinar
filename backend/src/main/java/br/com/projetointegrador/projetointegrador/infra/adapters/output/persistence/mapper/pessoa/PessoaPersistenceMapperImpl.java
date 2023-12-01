package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class PessoaPersistenceMapperImpl implements PessoaPersistenceMapper {

    private final ModelMapper modelMapper;
    @Override
    public PessoaEntity toPessoaEntity(Pessoa pessoa) {
        return modelMapper.map(pessoa,PessoaEntity.class);
    }

    @Override
    public Pessoa toPessoa(PessoaEntity pessoaEntity) {
        return modelMapper.map(pessoaEntity, Pessoa.class);
    }

    @Override
    public List<Pessoa> toPessoas(List<PessoaEntity> pessoaEntities) {
        return pessoaEntities.stream().map(this::toPessoa).collect(Collectors.toList());
    }
}
