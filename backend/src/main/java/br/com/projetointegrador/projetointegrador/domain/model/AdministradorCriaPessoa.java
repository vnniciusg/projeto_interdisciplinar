package br.com.projetointegrador.projetointegrador.domain.model;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

public class AdministradorCriaPessoa {
    private Long acpId;
    private Pessoa acpIdAdministrador;
    private Pessoa acpIdPessoa;

    public AdministradorCriaPessoa(){

    }
    public AdministradorCriaPessoa(Long acpId, Pessoa acpIdAdministrador, Pessoa acpIdPessoa) {
        this.acpId = acpId;
        this.acpIdAdministrador = acpIdAdministrador;
        this.acpIdPessoa = acpIdPessoa;
    }

    public Long getAcpId() {
        return acpId;
    }

    public void setAcpId(Long acpId) {
        this.acpId = acpId;
    }

    public Pessoa getAcpIdAdministrador() {
        return acpIdAdministrador;
    }

    public void setAcpIdAdministrador(Pessoa acpIdAdministrador) {
        this.acpIdAdministrador = acpIdAdministrador;
    }

    public Pessoa getAcpIdPessoa() {
        return acpIdPessoa;
    }

    public void setAcpIdPessoa(Pessoa acpIdPessoa) {
        this.acpIdPessoa = acpIdPessoa;
    }
}

