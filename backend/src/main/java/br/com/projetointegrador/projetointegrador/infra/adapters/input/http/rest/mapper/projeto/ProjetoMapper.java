package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.mapper.projeto;

import br.com.projetointegrador.projetointegrador.application.dto.projeto.response.ListarProjetosResponseDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;

import java.util.List;

public interface ProjetoMapper {

    ListarProjetosResponseDTO toProjetoResponse(Projeto projeto);
    List<ListarProjetosResponseDTO> toProjetosResponse(List<Projeto> projetos);

}
