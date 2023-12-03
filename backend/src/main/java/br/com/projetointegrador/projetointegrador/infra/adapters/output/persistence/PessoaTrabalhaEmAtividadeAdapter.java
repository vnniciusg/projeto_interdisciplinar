package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence;

import br.com.projetointegrador.projetointegrador.application.dto.pessoaTrabalhaEmAtividade.request.CreatePessoaTrabalhaEmAtividadeDTO;
import br.com.projetointegrador.projetointegrador.application.ports.output.PessoaTrabalhaEmAtividadeOutputPort;
import br.com.projetointegrador.projetointegrador.domain.model.PessoaTrabalhaEmAtividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.AtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaTabalhaEmAtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.PessoaTrabalhaEmAtividade.PessoaTrabalhaEmAtividadeMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.AtividadeRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.PessoaRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.PessoaTrabalhaEmAtividadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

@AllArgsConstructor
public class PessoaTrabalhaEmAtividadeAdapter implements PessoaTrabalhaEmAtividadeOutputPort {

    private final PessoaTrabalhaEmAtividadeRepository pessoaTrabalhaEmAtividadeRepository;
    private final PessoaRepository pessoaRepository;
    private final AtividadeRepository atividadeRepository;
    private final PessoaTrabalhaEmAtividadeMapper pessoaTrabalhaEmAtividadeMapper;
    @Override
    public PessoaTrabalhaEmAtividade criarPessoaTrabalhaEmAtividade(CreatePessoaTrabalhaEmAtividadeDTO createPessoaTrabalhaEmAtividadeDTO) {
       try{
           Long ptaIDPessoa = createPessoaTrabalhaEmAtividadeDTO.getPtaIdPessoa();

           Optional<PessoaEntity> pessoaEntityOptional = pessoaRepository.findById(ptaIDPessoa);

           PessoaEntity pessoaEntity = pessoaEntityOptional.orElseThrow(() ->
                   new IllegalArgumentException("ID PESSOA NÃO ENCCONTRADO"));


           Long ptaIDAtividade = createPessoaTrabalhaEmAtividadeDTO.getPtaIdAtividade();

           Optional<AtividadeEntity> atividadeEntityOptional = atividadeRepository.findById(ptaIDAtividade);

           AtividadeEntity atividadeEntity = atividadeEntityOptional.orElseThrow(() ->
                   new IllegalArgumentException("ID ATIVIDADE NAO FOI ENCONTRADO")
           );

           PessoaTabalhaEmAtividadeEntity pessoaTabalhaEmAtividadeEntity = new PessoaTabalhaEmAtividadeEntity();

           pessoaTabalhaEmAtividadeEntity.setPtaPessoa(pessoaEntity);
           pessoaTabalhaEmAtividadeEntity.setPtaAtividade(atividadeEntity);
           pessoaTabalhaEmAtividadeEntity.setPtpDataFim(createPessoaTrabalhaEmAtividadeDTO.getPtpDataFim());
           pessoaTabalhaEmAtividadeEntity.setPtpDataInicio(createPessoaTrabalhaEmAtividadeDTO.getPtpDataInicio());

           PessoaTabalhaEmAtividadeEntity pessoaTabalhaEmAtividadeResult = pessoaTrabalhaEmAtividadeRepository.save(pessoaTabalhaEmAtividadeEntity);

           return pessoaTrabalhaEmAtividadeMapper.toPessoaTrabalhaEmAtividade(pessoaTabalhaEmAtividadeResult);

       }catch (DataIntegrityViolationException e){
           throw new RuntimeException(e.getMessage());
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }
    }
}
