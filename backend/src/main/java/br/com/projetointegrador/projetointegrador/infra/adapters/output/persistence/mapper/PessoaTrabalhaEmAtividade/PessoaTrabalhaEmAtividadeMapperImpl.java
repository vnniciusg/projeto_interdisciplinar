package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.PessoaTrabalhaEmAtividade;

import br.com.projetointegrador.projetointegrador.domain.model.PessoaTrabalhaEmAtividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaTabalhaEmAtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade.AtividadePersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa.PessoaPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaTrabalhaEmAtividadeMapperImpl implements PessoaTrabalhaEmAtividadeMapper{

    private final AtividadePersistenceMapper atividadePersistenceMapper;
    private final PessoaPersistenceMapper pessoaPersistenceMapper;

    @Override
    public PessoaTrabalhaEmAtividade toPessoaTrabalhaEmAtividade(PessoaTabalhaEmAtividadeEntity pessoaTabalhaEmAtividadeEntity) {
        PessoaTrabalhaEmAtividade pessoaTrabalhaEmAtividade = new PessoaTrabalhaEmAtividade();

        pessoaTrabalhaEmAtividade.setPtaId(pessoaTrabalhaEmAtividade.getPtaId());
        pessoaTrabalhaEmAtividade.setPtaAtividade(atividadePersistenceMapper.toAtividade(pessoaTabalhaEmAtividadeEntity.getPtaAtividade()));
        pessoaTrabalhaEmAtividade.setPtaPessoa(pessoaPersistenceMapper.toPessoa(pessoaTabalhaEmAtividadeEntity.getPtaPessoa()));
        pessoaTrabalhaEmAtividade.setPtpDataFim(pessoaTabalhaEmAtividadeEntity.getPtpDataFim());
        pessoaTrabalhaEmAtividade.setPtpDataInicio(pessoaTabalhaEmAtividadeEntity.getPtpDataInicio());

        return pessoaTrabalhaEmAtividade;
    }
}
