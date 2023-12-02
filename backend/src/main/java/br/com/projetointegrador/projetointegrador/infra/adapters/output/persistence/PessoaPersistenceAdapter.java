package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence;

import br.com.projetointegrador.projetointegrador.application.ports.output.PessoaOutputPort;
import br.com.projetointegrador.projetointegrador.domain.dto.CriarPessoaDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa.PessoaPersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.PessoaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class PessoaPersistenceAdapter implements PessoaOutputPort {

    private final PessoaRepository pessoaRepository;
    private final PessoaPersistenceMapper pessoaPersistenceMapper;


    @Override
    public Pessoa criarPessoa(CriarPessoaDTO criarPessoaDTO) {
        try{
            PessoaEntity pessoaEntity = new PessoaEntity();
            pessoaEntity.setpRG(criarPessoaDTO.getpRG());
            pessoaEntity.setpCpf(criarPessoaDTO.getpCpf());
            pessoaEntity.setpTipo(criarPessoaDTO.getpTipo());
            pessoaEntity.setpSenha(criarPessoaDTO.getpSenha());
            pessoaEntity.setpNome(criarPessoaDTO.getpNome());
            pessoaEntity.setpNomeMae(criarPessoaDTO.getpNomeMae());
            pessoaEntity.setpNomePai(criarPessoaDTO.getpNomePai());
            pessoaEntity.setpTelResidencial(criarPessoaDTO.getpTelResidencial());
            pessoaEntity.setpTelRecado(criarPessoaDTO.getpTelRecado());
            pessoaEntity.setpDataCriacao(new Date());
            pessoaEntity = pessoaRepository.save(pessoaEntity);


        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Erro ao salvar pessoa : " + e.getMessage());
        }catch (Exception e){
            throw new RuntimeException("Algo de errado aconteceu ao criar pessoa : " + e.getMessage());
        }
    }

    @Override
    public List<Pessoa> list() {
        return null;
    }

    @Override
    public Boolean delete(Long pessoa_id) {
        return null;
    }

    @Override
    public Boolean update(Pessoa pessoa) {
        return null;
    }
}
