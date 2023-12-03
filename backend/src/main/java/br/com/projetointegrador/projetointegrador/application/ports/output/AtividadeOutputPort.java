package br.com.projetointegrador.projetointegrador.application.ports.output;

import br.com.projetointegrador.projetointegrador.application.dto.atividade.request.CriarAtividadeRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;

import java.util.List;

public interface AtividadeOutputPort {
    Atividade save(CriarAtividadeRequestDTO requestDTO);
    List<Atividade> list();

    List<Atividade> listarAtividadesPorPessoaCadastra(Long id);
    Boolean delete(Long atividadId);
    Boolean update(Atividade atividade);
}
