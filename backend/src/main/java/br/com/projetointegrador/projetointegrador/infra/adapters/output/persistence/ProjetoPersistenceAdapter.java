package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence;

import br.com.projetointegrador.projetointegrador.application.ports.output.ProjetoOutputPort;
import br.com.projetointegrador.projetointegrador.domain.dto.CriarProjetoRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.TipoPessoa;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.AtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.administrador.AdministradorCriaAtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.administrador.AdministradorCriaProjetoEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.coordenador.CoordenadorCriaAtivadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.coordenador.CoordenadorCriaProjetoEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.projeto.ProjetoPersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.PessoaRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.ProjetoRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.administrador.AdministradorCriaProjetoRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.coordenador.CoordenadorCriaProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProjetoPersistenceAdapter implements ProjetoOutputPort {

    private final ProjetoRepository projetoRepository;
    private final ProjetoPersistenceMapper projetoPersistenceMapper;
    private final AdministradorCriaProjetoRepository administradorCriaProjetoRepository;
    private final CoordenadorCriaProjetoRepository coordenadorCriaProjetoRepository;
    private final PessoaRepository pessoaRepository;
    @Override
    public Projeto save(CriarProjetoRequestDTO requestDTO) {
        try{
            ProjetoEntity projetoEntity = new ProjetoEntity();
            projetoEntity.setPrNome(requestDTO.getPrNome());
            projetoEntity.setPrObjetivo(requestDTO.getPrObjetiv());
            projetoEntity.setPrRecursos(requestDTO.getPrRecursos());

            Optional<PessoaEntity> pessoaEntityOptional = pessoaRepository.findById(requestDTO.getPrIdPessoaCadastra());

            PessoaEntity pessoaEntity = pessoaEntityOptional.orElseThrow(() ->
                    new IllegalArgumentException("Não foi possivel encontrar a pessoa que está cadastrando o projeto : " + requestDTO.getPrIdPessoaCadastra()));

            projetoEntity.setPrPessoaCadastra(pessoaEntity);

            ProjetoEntity projeto = projetoRepository.save(projetoEntity);

            VerificaTipoPessoaESalvaNoBanco(projetoEntity);

            return projetoPersistenceMapper.toProjeto(projeto);
        }catch(DataIntegrityViolationException e){
            throw new RuntimeException("Erro ao salvar projeto : " + e.getMessage());
        }catch (Exception e){
            throw new RuntimeException("Algo inesperado ocorreu ao salvar o projeto " + e.getMessage());
        }
    }

    @Override
    public List<Projeto> list() {
        try{
            return projetoPersistenceMapper.toProjetos(projetoRepository.findAll());
        }catch (Exception e){
            throw new RuntimeException("Algo inesperado ocorreu ao listar projetos : "  + e.getMessage());
        }

    }

    @Override
    public Boolean delete(Long projetoId) {
        try{
            return true;
        }catch(Exception e){
            throw new RuntimeException("Algo inesperado ocorreu ao deletar projeto " + projetoId + " : "  + e.getMessage());
        }

    }

    @Override
    public Boolean update(Projeto projeto) {
        return null;
    }

    private void VerificaTipoPessoaESalvaNoBanco(ProjetoEntity projetoEntity){
        if (TipoPessoa.ADMINISTRADOR == projetoEntity.getPrPessoaCadastra().getPTipo()){
            try{
                AdministradorCriaProjetoEntity administradorCriaProjetoEntity = new AdministradorCriaProjetoEntity();
                administradorCriaProjetoEntity.setAcprIdProjeto(projetoEntity);
                administradorCriaProjetoEntity.setAcpridAdministrador(projetoEntity.getPrPessoaCadastra());
                administradorCriaProjetoRepository.save(administradorCriaProjetoEntity);
            }catch (Exception e){
                throw new RuntimeException("Erro ao salvar a projeto em administrador cadastra projetos : " + e.getMessage());
            }

        }

        if(TipoPessoa.COORDENADOR == projetoEntity.getPrPessoaCadastra().getPTipo()){
            try{
                CoordenadorCriaProjetoEntity coordenadorCriaProjetoEntity = new CoordenadorCriaProjetoEntity();
                coordenadorCriaProjetoEntity.setCcpIdProjeto(projetoEntity);
                coordenadorCriaProjetoEntity.setCcpIdCoordenador(coordenadorCriaProjetoEntity.getCcpIdCoordenador());
                coordenadorCriaProjetoRepository.save(coordenadorCriaProjetoEntity);
            }catch (Exception e){
                throw new RuntimeException("Erro ao salvar projeto em coordenador cadastra projetos : " + e.getMessage());
            }

        }

    }

}
