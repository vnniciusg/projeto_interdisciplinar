package br.com.projetointegrador.projetointegrador.application.ports.input;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

import java.util.List;

public interface PessoaUseCase {
    Pessoa criarPessoa(Pessoa pessoa);
    List<Pessoa> listarPessoas();
    Boolean deletarPessoa(Long pessoaId);
    Boolean atualizarPessoa(Pessoa pessoa);
}
