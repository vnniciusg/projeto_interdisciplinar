package br.com.projetointegrador.projetointegrador.infra.adapters.config;

import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.ProjetoPersistenceAdapter;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade.ProjetoPersistenceMapper;
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
}
