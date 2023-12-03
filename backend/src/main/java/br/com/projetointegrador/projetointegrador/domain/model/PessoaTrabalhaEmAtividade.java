package br.com.projetointegrador.projetointegrador.domain.model;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

import java.util.Date;

public class PessoaTrabalhaEmAtividade {

    private Long ptaId;
    private Projeto ptaProjeto;
    private Pessoa ptaPessoa;
    private Date ptpDataInicio;
    private Date ptpDataFim;


    public PessoaTrabalhaEmAtividade(){

    }

    public PessoaTrabalhaEmAtividade(Long ptaId, Projeto ptaProjeto, Pessoa ptaPessoa, Date ptpDataInicio, Date ptpDataFim) {
        this.ptaId = ptaId;
        this.ptaProjeto = ptaProjeto;
        this.ptaPessoa = ptaPessoa;
        this.ptpDataInicio = ptpDataInicio;
        this.ptpDataFim = ptpDataFim;
    }


    public Long getPtaId() {
        return ptaId;
    }

    public void setPtaId(Long ptaId) {
        this.ptaId = ptaId;
    }

    public Projeto getPtaProjeto() {
        return ptaProjeto;
    }

    public void setPtaProjeto(Projeto ptaProjeto) {
        this.ptaProjeto = ptaProjeto;
    }

    public Pessoa getPtaPessoa() {
        return ptaPessoa;
    }

    public void setPtaPessoa(Pessoa ptaPessoa) {
        this.ptaPessoa = ptaPessoa;
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
