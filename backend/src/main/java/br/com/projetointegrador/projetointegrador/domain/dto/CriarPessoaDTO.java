package br.com.projetointegrador.projetointegrador.domain.dto;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CriarPessoaDTO {
    private String pRG;
    private String pCpf;
    private TipoPessoa pTipo;
    private String pEmail;
    private String pSenha;
    private String pNome;
    private String pNomeMae;
    private String pNomePai;
    private String pTelResidencial;
    private String pTelRecado;

}
