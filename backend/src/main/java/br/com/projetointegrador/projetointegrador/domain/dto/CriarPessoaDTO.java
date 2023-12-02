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

    public String getpRG() {
        return pRG;
    }

    public void setpRG(String pRG) {
        this.pRG = pRG;
    }

    public String getpCpf() {
        return pCpf;
    }

    public void setpCpf(String pCpf) {
        this.pCpf = pCpf;
    }

    public TipoPessoa getpTipo() {
        return pTipo;
    }

    public void setpTipo(TipoPessoa pTipo) {
        this.pTipo = pTipo;
    }

    public String getpSenha() {
        return pSenha;
    }

    public void setpSenha(String pSenha) {
        this.pSenha = pSenha;
    }

    public String getpNome() {
        return pNome;
    }

    public void setpNome(String pNome) {
        this.pNome = pNome;
    }

    public String getpNomeMae() {
        return pNomeMae;
    }

    public void setpNomeMae(String pNomeMae) {
        this.pNomeMae = pNomeMae;
    }

    public String getpNomePai() {
        return pNomePai;
    }

    public void setpNomePai(String pNomePai) {
        this.pNomePai = pNomePai;
    }

    public String getpTelResidencial() {
        return pTelResidencial;
    }

    public void setpTelResidencial(String pTelResidencial) {
        this.pTelResidencial = pTelResidencial;
    }

    public String getpTelRecado() {
        return pTelRecado;
    }

    public void setpTelRecado(String pTelRecado) {
        this.pTelRecado = pTelRecado;
    }

    private TipoPessoa pTipo;
    private String pSenha;
    private String pNome;
    private String pNomeMae;
    private String pNomePai;
    private String pTelResidencial;
    private String pTelRecado;
}
