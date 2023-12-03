package br.com.projetointegrador.projetointegrador.application.ports.input;

import br.com.projetointegrador.projetointegrador.application.dto.projeto.request.CriarProjetoRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;

import java.util.List;

public interface ProjetoUseCase {
    Projeto criarProjeto(CriarProjetoRequestDTO requestDTO);
    List<Projeto> listarProjetos();
    Boolean deletarProjeto(Long projetoId);
    Boolean atualizarProjeto(Projeto projeto);
}
