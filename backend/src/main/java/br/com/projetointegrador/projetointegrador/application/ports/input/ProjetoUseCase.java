package br.com.projetointegrador.projetointegrador.application.ports.input;

import br.com.projetointegrador.projetointegrador.domain.model.Projeto;

import java.util.List;
import java.util.UUID;

public interface ProjetoUseCase {
    Projeto criarProjeto(Projeto projeto);
    List<Projeto> listarProjetos();
    Boolean deletarProjeto(Long projetoId);
    Boolean atualizarProjeto(Projeto projeto);
}
