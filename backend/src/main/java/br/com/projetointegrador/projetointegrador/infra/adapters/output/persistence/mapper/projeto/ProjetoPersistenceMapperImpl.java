package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.projeto;

import br.com.projetointegrador.projetointegrador.domain.dto.CriarProjetoRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjetoPersistenceMapperImpl implements ProjetoPersistenceMapper {

    private final ModelMapper modelMapper;
    @Override
    public ProjetoEntity toProjetoEntity(CriarProjetoRequestDTO criarProjetoRequestDTO) {
        return modelMapper.map(criarProjetoRequestDTO, ProjetoEntity.class);
    }
    @Override
    public Projeto toProjeto(ProjetoEntity projetoEntity) {
        return modelMapper.map(projetoEntity , Projeto.class);
    }

    @Override
    public List<Projeto> toProjetos(List<ProjetoEntity> projetosEntity) {
        return projetosEntity.stream().map(this::toProjeto).collect(Collectors.toList());
    }
}
