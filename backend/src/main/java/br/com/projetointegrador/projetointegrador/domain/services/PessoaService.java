package br.com.projetointegrador.projetointegrador.domain.services;

import br.com.projetointegrador.projetointegrador.application.ports.input.PessoaUseCase;
import br.com.projetointegrador.projetointegrador.application.ports.output.PessoaOutputPort;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

import java.util.List;

public class PessoaService implements PessoaUseCase {

    private final PessoaOutputPort pessoaOutputPort;

    public PessoaService(PessoaOutputPort pessoaOutputPort) {
        this.pessoaOutputPort = pessoaOutputPort;
    }

    @Override
    public Pessoa criarPessoa(Pessoa pessoa){return pessoaOutputPort.criarPessoa(pessoa);}

    @Override
    public List<Pessoa> listarPessoas() {
        return pessoaOutputPort.list();
    }

    @Override
    public Boolean deletarPessoa(Long pessoaId) {
        return null;
    }

    @Override
    public Boolean atualizarPessoa(Pessoa pessoa) {
        return null;
    }
}
