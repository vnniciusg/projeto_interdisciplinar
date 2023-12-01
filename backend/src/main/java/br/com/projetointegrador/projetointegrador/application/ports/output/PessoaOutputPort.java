package br.com.projetointegrador.projetointegrador.application.ports.output;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaOutputPort {

    Pessoa criarPessoa(Pessoa pessoa);
    List<Pessoa> list();
    Boolean delete(Long pessoa_id);

    Boolean update(Pessoa pessoa);

}
