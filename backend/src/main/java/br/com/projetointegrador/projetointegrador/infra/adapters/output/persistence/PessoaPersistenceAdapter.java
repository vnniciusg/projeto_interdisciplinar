package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence;

import br.com.projetointegrador.projetointegrador.application.ports.output.PessoaOutputPort;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa.PessoaPersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.PessoaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PessoaPersistenceAdapter implements PessoaOutputPort {

    private final PessoaRepository pessoaRepository;
    private final PessoaPersistenceMapper pessoaPersistenceMapper;

    @Override
    public Pessoa criarPessoa(Pessoa pessoa) {
        try{
            PessoaEntity pessoaEntity = pessoaPersistenceMapper.toPessoaEntity(pessoa);
            pessoaEntity = pessoaRepository.save(pessoaEntity);
            return pessoaPersistenceMapper.toPessoa(pessoaEntity);
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
