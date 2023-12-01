package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;

public interface PessoaPersistenceMapper {
    PessoaEntity toPessoaEntity(Pessoa pessoa);
    Pessoa toPessoa(PessoaEntity pessoaEntity);
}
