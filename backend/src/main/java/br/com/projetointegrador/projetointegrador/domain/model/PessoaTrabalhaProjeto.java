package br.com.projetointegrador.projetointegrador.domain.model;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

import java.util.Date;

public class PessoaTrabalhaProjeto {

    private Long ptpId;
    private Pessoa ptpPessoa;
    private Projeto ptpProjeto;
    private Date ptpDataInicio;
    private Date ptpDataFim;

    public PessoaTrabalhaProjeto(){

    }
    public PessoaTrabalhaProjeto(Long ptpId, Pessoa ptpPessoa, Projeto ptpProjeto, Date ptpDataInicio, Date ptpDataFim) {
        this.ptpId = ptpId;
        this.ptpPessoa = ptpPessoa;
        this.ptpProjeto = ptpProjeto;
        this.ptpDataInicio = ptpDataInicio;
        this.ptpDataFim = ptpDataFim;
    }

    public Long getPtpId() {
        return ptpId;
    }

    public void setPtpId(Long ptpId) {
        this.ptpId = ptpId;
    }

    public Pessoa getPtpPessoa() {
        return ptpPessoa;
    }

    public void setPtpPessoa(Pessoa ptpPessoa) {
        this.ptpPessoa = ptpPessoa;
    }

    public Projeto getPtpProjeto() {
        return ptpProjeto;
    }

    public void setPtpProjeto(Projeto ptpProjeto) {
        this.ptpProjeto = ptpProjeto;
    }

    public Date getPtpDataInicio() {
        return ptpDataInicio;
    }

    public void setPtpDataInicio(Date ptpDataInicio) {
        this.ptpDataInicio = ptpDataInicio;
    }

    public Date getPtpDataFim() {
        return ptpDataFim;
    }

    public void setPtpDataFim(Date ptpDataFim) {
        this.ptpDataFim = ptpDataFim;
    }
}
