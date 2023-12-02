package br.com.projetointegrador.projetointegrador.domain.services;

import br.com.projetointegrador.projetointegrador.application.ports.input.PessoaUseCase;
import br.com.projetointegrador.projetointegrador.application.ports.output.PessoaOutputPort;
import br.com.projetointegrador.projetointegrador.domain.dto.CriarPessoaDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

import java.util.List;

public class PessoaService implements PessoaUseCase {

    private final PessoaOutputPort pessoaOutputPort;

    public PessoaService(PessoaOutputPort pessoaOutputPort) {
        this.pessoaOutputPort = pessoaOutputPort;
    }


    @Override
    public Pessoa criarPessoa(CriarPessoaDTO requestDTO) {
        return pessoaOutputPort.criarPessoa(requestDTO);
    }

    @Override
    public List<Pessoa> listarPessoas() {
        return pessoaOutputPort.list();
    }

    @Override
    public Boolean deletarPessoa(Long pessoaId) {
        return pessoaOutputPort.delete(pessoaId);
    }

    @Override
    public Pessoa atualizarPessoa(Pessoa pessoa) {
        return pessoaOutputPort.update(pessoa);
    }
}
