package br.com.projetointegrador.projetointegrador.domain.model.Pessoa;

import java.util.Date;

public class Pessoa {
    private Long pID;
    private String pRG;
    private String pCpf;
    private TipoPessoa pTipo;
    private String pEmail;
    private String pSenha;
    private String pNome;
    private String pNomeMae;
    private String pNomePai;
    private String pTelResidencial ;
    private String pTelRecado;
    private Pessoa pPessoaCadastra;
    private Date pDataCriacação;

    public Pessoa(){

    }
    public Pessoa(Long pID, String pRG, String pCpf, TipoPessoa pTipo, String pEmail, String pSenha, String pNome, String pNomeMae, String pNomePai, String pTelResidencial, String pTelRecado, Pessoa pPessoaCadastra, Date pDataCriacação) {
        this.pID = pID;
        this.pRG = pRG;
        this.pCpf = pCpf;
        this.pTipo = pTipo;
        this.pEmail = pEmail;
        this.pSenha = pSenha;
        this.pNome = pNome;
        this.pNomeMae = pNomeMae;
        this.pNomePai = pNomePai;
        this.pTelResidencial = pTelResidencial;
        this.pTelRecado = pTelRecado;
        this.pPessoaCadastra = pPessoaCadastra;
        this.pDataCriacação = pDataCriacação;
    }

    public Long getpID() {
        return pID;
    }

    public void setpID(Long pID) {
        this.pID = pID;
    }

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

    public Pessoa getpPessoaCadastra() {
        return pPessoaCadastra;
    }

    public void setpPessoaCadastra(Pessoa pPessoaCadastra) {
        this.pPessoaCadastra = pPessoaCadastra;
    }

    public Date getpDataCriacação() {
        return pDataCriacação;
    }

    public void setpDataCriacação(Date pDataCriacação) {
        this.pDataCriacação = pDataCriacação;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }
}
