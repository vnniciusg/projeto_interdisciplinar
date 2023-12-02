package br.com.projetointegrador.projetointegrador.infra.adapters.config;

import br.com.projetointegrador.projetointegrador.domain.services.AtividadeService;
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
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.administrador.AdministradorCriaAtividadeRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.administrador.AdministradorCriaProjetoRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.coordenador.CoordenadorCriaAtividadeRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.coordenador.CoordenadorCriaProjetoRepository;
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
    public ProjetoPersistenceAdapter projetoPersistenceAdapter(
            ProjetoRepository projetoRepository ,
            ProjetoPersistenceMapper projetoPersistenceMapper,
            AdministradorCriaProjetoRepository administradorCriaProjetoRepository,
             CoordenadorCriaProjetoRepository coordenadorCriaProjetoRepository,
            PessoaRepository pessoaRepository
    ){
        return new ProjetoPersistenceAdapter(
                projetoRepository ,
                projetoPersistenceMapper,
                administradorCriaProjetoRepository,
                coordenadorCriaProjetoRepository,
                pessoaRepository
        );
    }
    @Bean
    public AtividadePersistenceAdapter atividadePersistenceAdapter(
            AtividadeRepository atividadeRepository,
            AtividadePersistenceMapper atividadePersistenceMapper ,
            AdministradorCriaAtividadeRepository administradorCriaAtividadeRepository,
            CoordenadorCriaAtividadeRepository coordenadorCriaAtividadeRepository,
            ProjetoRepository projetoRepository,
            PessoaRepository pessoaRepository
    ){
        return new AtividadePersistenceAdapter(
                atividadeRepository,
                atividadePersistenceMapper ,
                administradorCriaAtividadeRepository,
                coordenadorCriaAtividadeRepository,
                projetoRepository,
                pessoaRepository
        );
    }

    @Bean
    public PessoaPersistenceAdapter pessoaPersistenceAdapter(PessoaRepository pessoaRepository , PessoaPersistenceMapper pessoaPersistenceMapper){
        return new PessoaPersistenceAdapter(pessoaRepository , pessoaPersistenceMapper);
    }

    @Bean
    public ProjetoService projetoService(ProjetoPersistenceAdapter projetoPersistenceAdapter ){
        return new ProjetoService(projetoPersistenceAdapter);
    }

    @Bean
    public AtividadeService atividadeService(AtividadePersistenceAdapter atividadePersistenceAdapter){
        return new AtividadeService(atividadePersistenceAdapter);
    }
}
