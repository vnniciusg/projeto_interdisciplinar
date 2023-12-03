package br.com.projetointegrador.projetointegrador.application.ports.input;

import br.com.projetointegrador.projetointegrador.domain.dto.CriarProjetoRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;

import java.util.List;
import java.util.UUID;

public interface ProjetoUseCase {
    Projeto criarProjeto(CriarProjetoRequestDTO requestDTO);
    List<Projeto> listarProjetos();
    Boolean deletarProjeto(Long projetoId);
    Boolean atualizarProjeto(Projeto projeto);
}
