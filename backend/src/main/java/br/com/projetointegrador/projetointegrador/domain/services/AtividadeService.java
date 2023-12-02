package br.com.projetointegrador.projetointegrador.domain.services;

import br.com.projetointegrador.projetointegrador.application.ports.input.AtividadeUseCase;
import br.com.projetointegrador.projetointegrador.application.ports.output.AtividadeOutputPort;
import br.com.projetointegrador.projetointegrador.domain.dto.CriarAtividadeRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class AtividadeService implements AtividadeUseCase {

    private final AtividadeOutputPort atividadeOutputPort;
    @Override
    public Atividade criarAtividade(CriarAtividadeRequestDTO requestDTO) {
        return atividadeOutputPort.save(requestDTO);
    }

    @Override
    public List<Atividade> listarAtividades() {
        return atividadeOutputPort.list();
    }

    @Override
    public Boolean deletarAtividade(Long atividadeID) {
        return atividadeOutputPort.delete(atividadeID);
    }

    @Override
    public Boolean atualizarAtividade(Atividade atividade) {
        return atividadeOutputPort.update(atividade);
    }
}
