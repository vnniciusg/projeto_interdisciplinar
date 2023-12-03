package br.com.projetointegrador.projetointegrador.domain.model;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

public class CoordenadorCriaProjeto {
    private Long ccpId;
    private Pessoa ccpIdCoordenador;
    private Projeto ccpIdProjeto;

    public CoordenadorCriaProjeto(){

    }
    public CoordenadorCriaProjeto(Long ccpId, Pessoa ccpIdCoordenador, Projeto ccpIdProjeto) {
        this.ccpId = ccpId;
        this.ccpIdCoordenador = ccpIdCoordenador;
        this.ccpIdProjeto = ccpIdProjeto;
    }

    public Long getCcpId() {
        return ccpId;
    }

    public void setCcpId(Long ccpId) {
        this.ccpId = ccpId;
    }

    public Pessoa getCcpIdCoordenador() {
        return ccpIdCoordenador;
    }

    public void setCcpIdCoordenador(Pessoa ccpIdCoordenador) {
        this.ccpIdCoordenador = ccpIdCoordenador;
    }

    public Projeto getCcpIdProjeto() {
        return ccpIdProjeto;
    }

    public void setCcpIdProjeto(Projeto ccpIdProjeto) {
        this.ccpIdProjeto = ccpIdProjeto;
    }
}

