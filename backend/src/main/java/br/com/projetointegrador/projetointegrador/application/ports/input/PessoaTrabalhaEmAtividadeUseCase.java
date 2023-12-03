package br.com.projetointegrador.projetointegrador.application.ports.input;

import br.com.projetointegrador.projetointegrador.application.dto.pessoaTrabalhaEmAtividade.request.CreatePessoaTrabalhaEmAtividadeDTO;
import br.com.projetointegrador.projetointegrador.domain.model.PessoaTrabalhaEmAtividade;

import java.util.List;

public interface PessoaTrabalhaEmAtividadeUseCase {

    PessoaTrabalhaEmAtividade criarPessoaTrabalhaEmAtividade(CreatePessoaTrabalhaEmAtividadeDTO createPessoaTrabalhaEmAtividadeDTO);

    List<PessoaTrabalhaEmAtividade> listarPessoaTrabalhaEmAtividade();

}
