package br.com.projetointegrador.projetointegrador.application.dto.pessoa.response;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListarPessoaResponseDTO {
    private Long pId;
    private String pNome;
    private TipoPessoa pTipo;
}
