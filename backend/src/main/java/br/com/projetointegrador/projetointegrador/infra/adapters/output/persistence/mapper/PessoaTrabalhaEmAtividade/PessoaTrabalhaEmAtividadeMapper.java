package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.PessoaTrabalhaEmAtividade;

import br.com.projetointegrador.projetointegrador.domain.model.PessoaTrabalhaEmAtividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaTabalhaEmAtividadeEntity;

public interface PessoaTrabalhaEmAtividadeMapper {

     PessoaTrabalhaEmAtividade toPessoaTrabalhaEmAtividade(PessoaTabalhaEmAtividadeEntity pessoaTabalhaEmAtividadeEntity);
}
