package br.com.projetointegrador.projetointegrador.domain.model;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

public class Estagiario {

    private Long eId;
    private Pessoa ePessoa;
    private Long eRa;
    private Long ePeriodo;
    private String eCurso;
    private boolean eAcademico;
    public Estagiario(){

    }
    public Estagiario(Long eId, Pessoa ePessoa, Long eRa, Long ePeriodo, String eCurso, boolean eAcademico) {
        this.eId = eId;
        this.ePessoa = ePessoa;
        this.eRa = eRa;
        this.ePeriodo = ePeriodo;
        this.eCurso = eCurso;
        this.eAcademico = eAcademico;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public Pessoa getePessoa() {
        return ePessoa;
    }

    public void setePessoa(Pessoa ePessoa) {
        this.ePessoa = ePessoa;
    }

    public Long geteRa() {
        return eRa;
    }

    public void seteRa(Long eRa) {
        this.eRa = eRa;
    }

    public Long getePeriodo() {
        return ePeriodo;
    }

    public void setePeriodo(Long ePeriodo) {
        this.ePeriodo = ePeriodo;
    }

    public String geteCurso() {
        return eCurso;
    }

    public void seteCurso(String eCurso) {
        this.eCurso = eCurso;
    }

    public boolean iseAcademico() {
        return eAcademico;
    }

    public void seteAcademico(boolean eAcademico) {
        this.eAcademico = eAcademico;
    }
}

