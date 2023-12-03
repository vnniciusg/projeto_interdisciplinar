package br.com.projetointegrador.projetointegrador.application.ports.input;

import br.com.projetointegrador.projetointegrador.domain.dto.CriarPessoaDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

import java.util.List;

public interface PessoaUseCase {
    Pessoa criarPessoa(CriarPessoaDTO requestDTO);
    List<Pessoa> listarPessoas();
    Boolean deletarPessoa(Long pessoaId);
    Pessoa atualizarPessoa(Pessoa pessoa);


}
