package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.mapper.pessoa;

import br.com.projetointegrador.projetointegrador.application.dto.pessoa.response.ListarPessoaResponseDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

public interface PessoaMapper {

    ListarPessoaResponseDTO toListarPessoaResponse(Pessoa pessoa);
}
