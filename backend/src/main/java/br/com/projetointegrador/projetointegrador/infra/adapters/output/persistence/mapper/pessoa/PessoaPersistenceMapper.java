package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;

import java.util.List;

public interface PessoaPersistenceMapper {
    PessoaEntity toPessoaEntity(Pessoa pessoa);
    Pessoa toPessoa(PessoaEntity pessoaEntity);

    List<Pessoa> toPessoas(List<PessoaEntity> pessoaEntities);
}
