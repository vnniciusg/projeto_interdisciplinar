package br.com.projetointegrador.projetointegrador.infra.adapters.config;

import br.com.projetointegrador.projetointegrador.domain.services.ProjetoService;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.AtividadePersistenceAdapter;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.PessoaPersistenceAdapter;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.ProjetoPersistenceAdapter;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade.AtividadePersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa.PessoaPersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.projeto.ProjetoPersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.AtividadeRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.PessoaRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.ProjetoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper (){
        return new ModelMapper();
    }
    @Bean
    public ProjetoPersistenceAdapter projetoPersistenceAdapter(ProjetoRepository projetoRepository , ProjetoPersistenceMapper projetoPersistenceMapper){
        return new ProjetoPersistenceAdapter(projetoRepository , projetoPersistenceMapper);
    }
    @Bean
    public AtividadePersistenceAdapter atividadePersistenceAdapter(AtividadeRepository atividadeRepository, AtividadePersistenceMapper atividadePersistenceMapper){
        return new AtividadePersistenceAdapter(atividadeRepository, atividadePersistenceMapper);
    }

    @Bean
    public PessoaPersistenceAdapter pessoaPersistenceAdapter(PessoaRepository pessoaRepository , PessoaPersistenceMapper pessoaPersistenceMapper){
        return new PessoaPersistenceAdapter(pessoaRepository , pessoaPersistenceMapper);
    }

    @Bean
    public ProjetoService projetoService(ProjetoPersistenceAdapter projetoPersistenceAdapter ){
        return new ProjetoService(projetoPersistenceAdapter);
    }
}
