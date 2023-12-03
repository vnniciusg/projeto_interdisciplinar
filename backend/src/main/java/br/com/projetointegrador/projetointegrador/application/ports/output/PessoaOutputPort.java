package br.com.projetointegrador.projetointegrador.application.ports.output;

import br.com.projetointegrador.projetointegrador.application.dto.pessoa.request.CriarPessoaRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

import java.util.List;

public interface PessoaOutputPort {

    Pessoa criarPessoa(CriarPessoaRequestDTO criarPessoaRequestDTO);
    List<Pessoa> list();
    Boolean delete(Long pessoa_id);

    Pessoa update(Pessoa pessoa);

}
