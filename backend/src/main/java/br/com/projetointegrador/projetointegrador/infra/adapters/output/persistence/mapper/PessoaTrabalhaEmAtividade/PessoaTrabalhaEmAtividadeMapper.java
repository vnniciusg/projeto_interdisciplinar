package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.PessoaTrabalhaEmAtividade;

import br.com.projetointegrador.projetointegrador.domain.model.PessoaTrabalhaEmAtividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaTrabalhaEmAtividadeEntity;

import java.util.List;

public interface PessoaTrabalhaEmAtividadeMapper {

     PessoaTrabalhaEmAtividade toPessoaTrabalhaEmAtividade(PessoaTrabalhaEmAtividadeEntity pessoaTrabalhaEmAtividadeEntity);

     List<PessoaTrabalhaEmAtividade> toPessoaTabalhaEmAtividades(List<PessoaTrabalhaEmAtividadeEntity> pessoaTabalhaEmAtividadeEntities);
}
