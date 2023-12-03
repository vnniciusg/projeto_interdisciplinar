package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class PessoaPersistenceMapperImpl implements PessoaPersistenceMapper {

    @Override
    public PessoaEntity toPessoaEntity(Pessoa pessoa) {
        return toPessoaEntity(pessoa, new HashSet<>());
    }

    private PessoaEntity toPessoaEntity(Pessoa pessoa , Set<Pessoa> converted) {
        if(pessoa == null || converted.contains(pessoa)){
            return null;
        }

        converted.add(pessoa);

        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setPRG(pessoa.getpRG());
        pessoaEntity.setPCpf(pessoa.getpCpf());
        pessoaEntity.setPEmail(pessoa.getpEmail());
        pessoaEntity.setPSenha(pessoa.getpSenha());
        pessoaEntity.setPNome(pessoa.getpNome());
        pessoaEntity.setPTipo(pessoa.getpTipo());
        pessoaEntity.setPNomeMae(pessoa.getpNomeMae());
        pessoaEntity.setPNomePai(pessoa.getpNomePai());
        pessoaEntity.setPPessoaCadastra(toPessoaEntity(pessoa.getpPessoaCadastra(), converted));
        pessoaEntity.setPDataCriacao(pessoa.getpDataCriacação());

        return pessoaEntity;
    }

    @Override
    public Pessoa toPessoa(PessoaEntity pessoaEntity) {
        return toPessoa(pessoaEntity, new HashSet<>());
    }

    private Pessoa toPessoa(PessoaEntity pessoaEntity, Set<PessoaEntity> converted){
        if(pessoaEntity == null || converted.contains(pessoaEntity)){
            return null;
        }

        converted.add(pessoaEntity);
        Pessoa pessoa = new Pessoa();
        pessoa.setpID(pessoaEntity.getPID());
        pessoa.setpRG(pessoaEntity.getPRG());
        pessoa.setpTipo(pessoaEntity.getPTipo());
        pessoa.setpCpf(pessoaEntity.getPCpf());
        pessoa.setpEmail(pessoaEntity.getPEmail());
        pessoa.setpSenha(pessoaEntity.getPSenha());
        pessoa.setpNome(pessoaEntity.getPNome());
        pessoa.setpNomeMae(pessoaEntity.getPNomeMae());
        pessoa.setpNomePai(pessoaEntity.getPNomePai());
        pessoa.setpPessoaCadastra(toPessoa(pessoaEntity.getPPessoaCadastra(), converted));
        pessoa.setpDataCriacação(pessoaEntity.getPDataCriacao());

        return pessoa;

    }

    @Override
    public List<Pessoa> toPessoas(List<PessoaEntity> pessoaEntities) {
        return pessoaEntities.stream().map(this::toPessoa).collect(Collectors.toList());
    }
}
