package br.com.projetointegrador.projetointegrador.domain.model;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

public class CoordenadorCriaAtivade {
    private Long ccaId;
    private Pessoa ccaIdCoordenador;
    private Atividade ccaIdAtividade;

    public CoordenadorCriaAtivade(){

    }
    public CoordenadorCriaAtivade(Long ccaId, Pessoa ccaIdCoordenador, Atividade ccaIdAtividade) {
        this.ccaId = ccaId;
        this.ccaIdCoordenador = ccaIdCoordenador;
        this.ccaIdAtividade = ccaIdAtividade;
    }

    public Long getCcaId() {
        return ccaId;
    }

    public void setCcaId(Long ccaId) {
        this.ccaId = ccaId;
    }

    public Pessoa getCcaIdCoordenador() {
        return ccaIdCoordenador;
    }

    public void setCcaIdCoordenador(Pessoa ccaIdCoordenador) {
        this.ccaIdCoordenador = ccaIdCoordenador;
    }

    public Atividade getCcaIdAtividade() {
        return ccaIdAtividade;
    }

    public void setCcaIdAtividade(Atividade ccaIdAtividade) {
        this.ccaIdAtividade = ccaIdAtividade;
    }
}
