package br.com.projetointegrador.projetointegrador.domain.model;


import br.com.projetointegrador.projetointegrador.domain.dto.CriarProjetoRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

public class Projeto {
    private Long prId;
    private String prNome;
    private String prRecursos;
    private String prObjetivo;
    private Pessoa prPessoaCoordena;
    private Pessoa prPessoaCadastra;

    public Projeto(){

    }
    public Projeto(Long prId, String prNome, String prRecursos, String prObjetivo, Pessoa prPessoaCoordena, Pessoa prPessoaCadastra) {
        this.prId = prId;
        this.prNome = prNome;
        this.prRecursos = prRecursos;
        this.prObjetivo = prObjetivo;
        this.prPessoaCoordena = prPessoaCoordena;
        this.prPessoaCadastra = prPessoaCadastra;
    }

    public static Projeto toProjeto(CriarProjetoRequestDTO projetoRequestDTO) {
        Projeto projeto = new Projeto();
        
        projeto.setPrNome(projetoRequestDTO.prNome());
        projeto.setPrObjetivo(projetoRequestDTO.prObjetivo());
        projeto.setPrRecursos(projetoRequestDTO.prRecursos());

        return projeto;
    }


    public Long getPrId() {
        return prId;
    }

    public void setPrId(Long prId) {
        this.prId = prId;
    }

    public String getPrNome() {
        return prNome;
    }

    public void setPrNome(String prNome) {
        this.prNome = prNome;
    }

    public String getPrRecursos() {
        return prRecursos;
    }

    public void setPrRecursos(String prRecursos) {
        this.prRecursos = prRecursos;
    }

    public String getPrObjetivo() {
        return prObjetivo;
    }

    public void setPrObjetivo(String prObjetivo) {
        this.prObjetivo = prObjetivo;
    }

    public Pessoa getPrPessoaCoordena() {
        return prPessoaCoordena;
    }

    public void setPrPessoaCoordena(Pessoa prPessoaCoordena) {
        this.prPessoaCoordena = prPessoaCoordena;
    }

    public Pessoa getPrPessoaCadastra() {
        return prPessoaCadastra;
    }

    public void setPrPessoaCadastra(Pessoa prPessoaCadastra) {
        this.prPessoaCadastra = prPessoaCadastra;
    }
}
