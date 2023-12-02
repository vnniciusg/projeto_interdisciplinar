package br.com.projetointegrador.projetointegrador.domain.dto;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CriarPessoaDTO {
    @JsonProperty("pRG")
    private String pRG;

    @JsonProperty("pCpf")
    private String pCpf;

    @JsonProperty("pTipo")
    private TipoPessoa pTipo;

    @JsonProperty("pEmail")
    private String pEmail;

    @JsonProperty("pSenha")
    private String pSenha;

    @JsonProperty("pNome")
    private String pNome;

    @JsonProperty("pNomeMae")
    private String pNomeMae;

    @JsonProperty("pNomePai")
    private String pNomePai;

    @JsonProperty("pTelResidencial")
    private String pTelResidencial;

    @JsonProperty("pTelRecado")
    private String pTelRecado;

}
