package br.com.projetointegrador.projetointegrador.domain.model.Atividade;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;

public class Atividade {
    private Long aId;
    private Projeto aProjeto;
    private String aDescricao;
    private TipoAtividade aTipo;
    private Pessoa aPessoaCadastra;

    public Atividade(){

    }
    public Atividade(Long aId, Projeto aProjeto, String aDescricao, TipoAtividade aTipo, Pessoa aPessoaCadastra) {
        this.aId = aId;
        this.aProjeto = aProjeto;
        this.aDescricao = aDescricao;
        this.aTipo = aTipo;
        this.aPessoaCadastra = aPessoaCadastra;
    }
    
    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public Projeto getaProjeto() {
        return aProjeto;
    }

    public void setaProjeto(Projeto aProjeto) {
        this.aProjeto = aProjeto;
    }

    public String getaDescricao() {
        return aDescricao;
    }

    public void setaDescricao(String aDescricao) {
        this.aDescricao = aDescricao;
    }

    public TipoAtividade getaTipo() {
        return aTipo;
    }

    public void setaTipo(TipoAtividade aTipo) {
        this.aTipo = aTipo;
    }

    public Pessoa getaPessoaCadastra() {
        return aPessoaCadastra;
    }

    public void setaPessoaCadastra(Pessoa aPessoaCadastra) {
        this.aPessoaCadastra = aPessoaCadastra;
    }
}
