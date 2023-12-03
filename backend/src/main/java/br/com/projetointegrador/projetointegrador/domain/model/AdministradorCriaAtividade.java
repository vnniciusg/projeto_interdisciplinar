package br.com.projetointegrador.projetointegrador.domain.model;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

public class AdministradorCriaAtividade {
    private Long acaId;
    private Pessoa acaIdAdministrador;
    private Atividade acaIdAtividade;

    public AdministradorCriaAtividade(){

    }
    public AdministradorCriaAtividade(Long acaId, Pessoa acaIdAdministrador, Atividade acaIdAtividade) {
        this.acaId = acaId;
        this.acaIdAdministrador = acaIdAdministrador;
        this.acaIdAtividade = acaIdAtividade;
    }

    public Long getAcaId() {
        return acaId;
    }

    public void setAcaId(Long acaId) {
        this.acaId = acaId;
    }

    public Pessoa getAcaIdAdministrador() {
        return acaIdAdministrador;
    }

    public void setAcaIdAdministrador(Pessoa acaIdAdministrador) {
        this.acaIdAdministrador = acaIdAdministrador;
    }

    public Atividade getAcaIdAtividade() {
        return acaIdAtividade;
    }

    public void setAcaIdAtividade(Atividade acaIdAtividade) {
        this.acaIdAtividade = acaIdAtividade;
    }
}
