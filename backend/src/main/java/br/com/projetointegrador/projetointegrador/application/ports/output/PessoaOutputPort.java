package br.com.projetointegrador.projetointegrador.application.ports.output;

import br.com.projetointegrador.projetointegrador.domain.dto.CriarPessoaDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaOutputPort {

    Pessoa criarPessoa(CriarPessoaDTO criarPessoaDTO);
    List<Pessoa> list();
    Boolean delete(Long pessoa_id);

    Pessoa update(Pessoa pessoa);

}
