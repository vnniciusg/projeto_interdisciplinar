package br.com.projetointegrador.projetointegrador.domain.services;

import br.com.projetointegrador.projetointegrador.application.ports.input.ProjetoUseCase;
import br.com.projetointegrador.projetointegrador.application.ports.output.ProjetoOutputPort;
import br.com.projetointegrador.projetointegrador.domain.dto.CriarProjetoRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class ProjetoService  implements ProjetoUseCase {

    private final ProjetoOutputPort projetoOutputPort;
    @Override
    public Projeto criarProjeto(CriarProjetoRequestDTO requestDTO) {
        return projetoOutputPort.save(requestDTO);
    }

    @Override
    public List<Projeto> listarProjetos() {
        return projetoOutputPort.list();
    }

    @Override
    public Boolean deletarProjeto(Long projetoId) {
        return null;
    }

    @Override
    public Boolean atualizarProjeto(Projeto projeto) {
        return null;
    }


}
