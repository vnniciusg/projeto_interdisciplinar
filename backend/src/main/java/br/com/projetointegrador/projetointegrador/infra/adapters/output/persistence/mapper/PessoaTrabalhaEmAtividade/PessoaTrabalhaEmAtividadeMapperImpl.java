package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.PessoaTrabalhaEmAtividade;

import br.com.projetointegrador.projetointegrador.domain.model.PessoaTrabalhaEmAtividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaTrabalhaEmAtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade.AtividadePersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa.PessoaPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PessoaTrabalhaEmAtividadeMapperImpl implements PessoaTrabalhaEmAtividadeMapper{

    private final AtividadePersistenceMapper atividadePersistenceMapper;
    private final PessoaPersistenceMapper pessoaPersistenceMapper;

    @Override
    public PessoaTrabalhaEmAtividade toPessoaTrabalhaEmAtividade(PessoaTrabalhaEmAtividadeEntity pessoaTrabalhaEmAtividadeEntity) {
        PessoaTrabalhaEmAtividade pessoaTrabalhaEmAtividade = new PessoaTrabalhaEmAtividade();

        pessoaTrabalhaEmAtividade.setPtaId(pessoaTrabalhaEmAtividade.getPtaId());
        pessoaTrabalhaEmAtividade.setPtaAtividade(atividadePersistenceMapper.toAtividade(pessoaTrabalhaEmAtividadeEntity.getPtaAtividade()));
        pessoaTrabalhaEmAtividade.setPtaPessoa(pessoaPersistenceMapper.toPessoa(pessoaTrabalhaEmAtividadeEntity.getPtaPessoa()));
        pessoaTrabalhaEmAtividade.setPtpDataFim(pessoaTrabalhaEmAtividadeEntity.getPtpDataFim());
        pessoaTrabalhaEmAtividade.setPtpDataInicio(pessoaTrabalhaEmAtividadeEntity.getPtpDataInicio());

        return pessoaTrabalhaEmAtividade;
    }

    @Override
    public List<PessoaTrabalhaEmAtividade> toPessoaTabalhaEmAtividades(List<PessoaTrabalhaEmAtividadeEntity> pessoaTrabalhaEmAtividadeEntities) {
        return pessoaTrabalhaEmAtividadeEntities.stream().map(this::toPessoaTrabalhaEmAtividade).collect(Collectors.toList());
    }
}
