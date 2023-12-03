package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.mapper.pessoa;

import br.com.projetointegrador.projetointegrador.application.dto.pessoa.response.ListarPessoaResponseDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapperImpl implements PessoaMapper {
    @Override
    public ListarPessoaResponseDTO toListarPessoaResponse(Pessoa pessoa) {
       ListarPessoaResponseDTO listarPessoaResponseDTO = new ListarPessoaResponseDTO();
       listarPessoaResponseDTO.setPId(pessoa.getpID());
       listarPessoaResponseDTO.setPTipo(pessoa.getpTipo());
       listarPessoaResponseDTO.setPNome(pessoa.getpNome());

       return listarPessoaResponseDTO;
    }
}
