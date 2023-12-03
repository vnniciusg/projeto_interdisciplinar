package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence;

import br.com.projetointegrador.projetointegrador.application.dto.pessoaTrabalhaEmAtividade.request.CreatePessoaTrabalhaEmAtividadeDTO;
import br.com.projetointegrador.projetointegrador.application.ports.output.PessoaTrabalhaEmAtividadeOutputPort;
import br.com.projetointegrador.projetointegrador.domain.model.PessoaTrabalhaEmAtividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.AtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaTrabalhaEmAtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.PessoaTrabalhaEmAtividade.PessoaTrabalhaEmAtividadeMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.AtividadeRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.PessoaRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.PessoaTrabalhaEmAtividadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
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
                   new IllegalArgumentException("ID PESSOA NÃO ENCONTRADO"));


           Long ptaIDAtividade = createPessoaTrabalhaEmAtividadeDTO.getPtaIdAtividade();

           Optional<AtividadeEntity> atividadeEntityOptional = atividadeRepository.findById(ptaIDAtividade);

           AtividadeEntity atividadeEntity = atividadeEntityOptional.orElseThrow(() ->
                   new IllegalArgumentException("ID ATIVIDADE NAO FOI ENCONTRADO")
           );

           PessoaTrabalhaEmAtividadeEntity pessoaTrabalhaEmAtividadeEntity = new PessoaTrabalhaEmAtividadeEntity();

           pessoaTrabalhaEmAtividadeEntity.setPtaPessoa(pessoaEntity);
           pessoaTrabalhaEmAtividadeEntity.setPtaAtividade(atividadeEntity);
           pessoaTrabalhaEmAtividadeEntity.setPtpDataFim(createPessoaTrabalhaEmAtividadeDTO.getPtpDataFim());
           pessoaTrabalhaEmAtividadeEntity.setPtpDataInicio(createPessoaTrabalhaEmAtividadeDTO.getPtpDataInicio());

           PessoaTrabalhaEmAtividadeEntity pessoaTabalhaEmAtividadeResult = pessoaTrabalhaEmAtividadeRepository.save(pessoaTrabalhaEmAtividadeEntity);

           return pessoaTrabalhaEmAtividadeMapper.toPessoaTrabalhaEmAtividade(pessoaTabalhaEmAtividadeResult);

       }catch (DataIntegrityViolationException e){
           throw new RuntimeException(e.getMessage());
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }
    }

    @Override
    public List<PessoaTrabalhaEmAtividade> listarPessoaTrabalhaEmAtividade() {
        List<PessoaTrabalhaEmAtividadeEntity> pessoaTrabalhaEmAtividadeEntities = pessoaTrabalhaEmAtividadeRepository.findAll();
        return pessoaTrabalhaEmAtividadeMapper.toPessoaTabalhaEmAtividades(pessoaTrabalhaEmAtividadeEntities);
    }

}
