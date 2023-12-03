package br.com.projetointegrador.projetointegrador.domain.model;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

import java.util.Date;

public class PessoaTrabalhaEmAtividade {

    private Long ptaId;
    private Atividade ptaAtividade;
    private Pessoa ptaPessoa;
    private Date ptpDataInicio;
    private Date ptpDataFim;


    public PessoaTrabalhaEmAtividade(){

    }

    public PessoaTrabalhaEmAtividade(Long ptaId, Atividade ptaAtividade, Pessoa ptaPessoa, Date ptpDataInicio, Date ptpDataFim) {
        this.ptaId = ptaId;
        this.ptaAtividade = ptaAtividade;
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

    public Atividade getPtaAtividade() {
        return ptaAtividade;
    }

    public void setPtaAtividade(Atividade ptaAtividade) {
        this.ptaAtividade = ptaAtividade;
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
