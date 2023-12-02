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
            pessoaEntity.setPRG(criarPessoaDTO.getPRG());
            pessoaEntity.setPCpf(criarPessoaDTO.getPCpf());
            pessoaEntity.setPTipo(criarPessoaDTO.getPTipo());
            pessoaEntity.setPEmail(criarPessoaDTO.getPEmail());
            pessoaEntity.setPSenha(criarPessoaDTO.getPSenha());
            pessoaEntity.setPNome(criarPessoaDTO.getPNome());
            pessoaEntity.setPNomeMae(criarPessoaDTO.getPNomeMae());
            pessoaEntity.setPNomePai(criarPessoaDTO.getPNomePai());
            pessoaEntity.setPTelResidencial(criarPessoaDTO.getPTelResidencial());
            pessoaEntity.setPTelRecado(criarPessoaDTO.getPTelRecado());
            pessoaEntity.setPDataCriacao(new Date());
            pessoaEntity = pessoaRepository.save(pessoaEntity);
            return pessoaPersistenceMapper.toPessoa(pessoaEntity);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Erro ao salvar pessoa : " + e.getMessage());
        }
        catch (Exception e){
            throw new RuntimeException("Algo de errado aconteceu ao criar pessoa : " + e.getMessage());
        }
    }

    @Override
    public List<Pessoa> list() {
        List<PessoaEntity> pessoaEntities = pessoaRepository.findAll();
        return pessoaPersistenceMapper.toPessoas(pessoaEntities);
    }

    @Override
    public Boolean delete(Long pessoa_id) {
        try{
            pessoaRepository.deleteById(pessoa_id);
            return true;
        }catch(Exception e){
            throw new RuntimeException("Algo inesperado ocorreu ao deletar pessoa " + pessoa_id + " : "  + e.getMessage());
        }

    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        Long pessoa_Id = pessoa.getpID();
        PessoaEntity pessoaEntity = pessoaRepository.findById(pessoa_Id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoaEntity.setPRG(pessoa.getpRG());
        pessoaEntity.setPCpf(pessoa.getpCpf());
        pessoaEntity.setPTipo(pessoa.getpTipo());
        pessoaEntity.setPEmail(pessoa.getpEmail());
        pessoaEntity.setPSenha(pessoa.getpSenha());
        pessoaEntity.setPNome(pessoa.getpNome());
        pessoaEntity.setPNomeMae(pessoa.getpNomeMae());
        pessoaEntity.setPNomePai(pessoa.getpNomePai());
        pessoaEntity.setPTelResidencial(pessoa.getpTelResidencial());
        pessoaEntity.setPTelRecado(pessoa.getpTelRecado());
        pessoaEntity.setPDataCriacao(new Date());
        pessoaEntity = pessoaRepository.save(pessoaEntity);
        return pessoaPersistenceMapper.toPessoa(pessoaEntity);
    }
}
