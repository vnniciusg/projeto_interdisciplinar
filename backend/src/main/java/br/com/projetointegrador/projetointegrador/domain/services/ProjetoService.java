package br.com.projetointegrador.projetointegrador.domain.services;

import br.com.projetointegrador.projetointegrador.application.ports.input.ProjetoUseCase;
import br.com.projetointegrador.projetointegrador.application.ports.output.ProjetoOutputPort;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class ProjetoService  implements ProjetoUseCase {

    private final ProjetoOutputPort projetoOutputPort;
    @Override
    public Projeto criarProjeto(Projeto projeto) {
        return projetoOutputPort.save(projeto);
    }

    @Override
    public List<Projeto> listarProjetos() {
        return projetoOutputPort.list();
    }

    @Override
    public Boolean deletarProjeto(UUID projeto_ID) {
        return projetoOutputPort.delete(projeto_ID);
    }

    @Override
    public Boolean atualizarProjeto(UUID projeto_ID, Projeto projeto) {
        return projetoOutputPort.update(projeto_ID , projeto);
    }
}
