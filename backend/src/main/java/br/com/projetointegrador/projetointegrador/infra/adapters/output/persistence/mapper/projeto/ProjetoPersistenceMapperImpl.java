package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.projeto;

import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa.PessoaPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjetoPersistenceMapperImpl implements ProjetoPersistenceMapper {

    private final PessoaPersistenceMapper pessoaPersistenceMapper;
    @Override
    public Projeto toProjeto(ProjetoEntity projetoEntity) {
        Projeto projeto = new Projeto();
        projeto.setPrId(projetoEntity.getPrId());
        projeto.setPrNome(projetoEntity.getPrNome());
        projeto.setPrObjetivo(projetoEntity.getPrObjetivo());
        projeto.setPrRecursos(projetoEntity.getPrRecursos());
        projeto.setPrPessoaCadastra(pessoaPersistenceMapper.toPessoa(projetoEntity.getPrPessoaCadastra()));
        if (projetoEntity.getPrPessoaCadastra() !=  null){
            projeto.setPrPessoaCoordena(pessoaPersistenceMapper.toPessoa(projetoEntity.getPrPessoaCoordena()));
        }
        return projeto;
    }

    @Override
    public List<Projeto> toProjetos(List<ProjetoEntity> projetosEntity) {
        return projetosEntity.stream().map(this::toProjeto).collect(Collectors.toList());
    }
}
