package br.com.projetointegrador.projetointegrador.application.ports.output;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

public interface PessoaOutputPort {

    Pessoa criarPessoa(Pessoa pessoa);
}
