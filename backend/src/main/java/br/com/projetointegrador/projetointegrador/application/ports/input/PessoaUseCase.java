package br.com.projetointegrador.projetointegrador.application.ports.input;

import br.com.projetointegrador.projetointegrador.application.dto.pessoa.request.CriarPessoaRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

import java.util.List;

public interface PessoaUseCase {
    Pessoa criarPessoa(CriarPessoaRequestDTO requestDTO);
    List<Pessoa> listarPessoas();
    Boolean deletarPessoa(Long pessoaId);
    Pessoa atualizarPessoa(Pessoa pessoa);


}
