package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.mapper.projeto;

import br.com.projetointegrador.projetointegrador.domain.dto.ListarProjetosResponseDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjetoMapperImpl implements ProjetoMapper{

    private final ModelMapper modelMapper;

    @Override
    public ListarProjetosResponseDTO toProjetoResponse(Projeto projeto) {
        return modelMapper.map(projeto , ListarProjetosResponseDTO.class);
    }

    @Override
    public List<ListarProjetosResponseDTO> toProjetosResponse(List<Projeto> projetos) {
        return projetos.stream().map(this::toProjetoResponse).collect(Collectors.toList());
    }
}
