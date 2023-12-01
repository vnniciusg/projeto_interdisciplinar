package br.com.projetointegrador.projetointegrador.domain.model;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

public class AdministradorCriaProjeto {
    private Long acprID;
    private Pessoa acpridAdministrador;
    private Projeto acprIdProjeto;

    public AdministradorCriaProjeto(){

    }
    public AdministradorCriaProjeto(Long acprID, Pessoa acpridAdministrador, Projeto acprIdProjeto) {
        this.acprID = acprID;
        this.acpridAdministrador = acpridAdministrador;
        this.acprIdProjeto = acprIdProjeto;
    }

    public Long getAcprID() {
        return acprID;
    }

    public void setAcprID(Long acprID) {
        this.acprID = acprID;
    }

    public Pessoa getAcpridAdministrador() {
        return acpridAdministrador;
    }

    public void setAcpridAdministrador(Pessoa acpridAdministrador) {
        this.acpridAdministrador = acpridAdministrador;
    }

    public Projeto getAcprIdProjeto() {
        return acprIdProjeto;
    }

    public void setAcprIdProjeto(Projeto acprIdProjeto) {
        this.acprIdProjeto = acprIdProjeto;
    }
}
