package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence;

import br.com.projetointegrador.projetointegrador.application.ports.output.AtividadeOutputPort;
import br.com.projetointegrador.projetointegrador.domain.dto.CriarAtividadeRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.TipoPessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.AtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.administrador.AdministradorCriaAtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.coordenador.CoordenadorCriaAtivadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.atividade.AtividadePersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.AtividadeRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.PessoaRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.ProjetoRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.administrador.AdministradorCriaAtividadeRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.coordenador.CoordenadorCriaAtividadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AtividadePersistenceAdapter implements AtividadeOutputPort {

    private final AtividadeRepository atividadeRepository;
    private final AtividadePersistenceMapper atividadePersistenceMapper;
    private final AdministradorCriaAtividadeRepository administradorCriaAtividadeRepository;
    private final CoordenadorCriaAtividadeRepository coordenadorCriaAtividadeRepository;
    private final ProjetoRepository projetoRepository;
    private final PessoaRepository pessoaRepository;


    @Override
    public Atividade save(CriarAtividadeRequestDTO atividade) {
        try {
            AtividadeEntity atividadeEntity = new AtividadeEntity();
            atividadeEntity.setATipo(atividade.getATipo());
            atividadeEntity.setADescricao(atividade.getADescricao());

            Optional<ProjetoEntity> projetoEntityOptional = projetoRepository.findById(atividade.getAIdProjeto());

            ProjetoEntity projetoEntity = projetoEntityOptional.orElseThrow(() ->
                    new IllegalArgumentException("Não foi encontrado projeto com esse ID : " + atividade.getAIdProjeto()));

            atividadeEntity.setAProjeto(projetoEntity);

            Optional<PessoaEntity> pessoaOptional = pessoaRepository.findById(atividade.getAIdPessoaCadastra());

            PessoaEntity pessoaEntity = pessoaOptional.orElseThrow(() ->
                    new IllegalArgumentException("Não foi encontrada pessoa com esse ID : " + atividade.getAIdPessoaCadastra()));

            atividadeEntity.setAPessoaCadastra(pessoaEntity);

            atividadeEntity = atividadeRepository.save(atividadeEntity);

            VerificaTipoPessoaESalvaNoBanco(atividadeEntity);

            return atividadePersistenceMapper.toAtividade(atividadeEntity);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Erro ao salvar atividade : " + e.getMessage());
        }catch (Exception e){
            throw new RuntimeException("Algo inesperado ocorreu ao salvar atividade : " + e.getMessage());
        }

    }
    @Override
    public List<Atividade> list() {
        try{
            return atividadePersistenceMapper.toAtividades(atividadeRepository.findAll());
        }catch (Exception e){
            throw new RuntimeException("Algo inesperado ocorreu ao listar atividade : " + e.getMessage());
        }
    }

    @Override
    public Boolean delete(Long atividadId) {
        return null;
    }

    @Override
    public Boolean update(Atividade atividade) {
        return null;
    }


    private void VerificaTipoPessoaESalvaNoBanco(AtividadeEntity atividadeEntity){
        if (TipoPessoa.ADMINISTRADOR == atividadeEntity.getAPessoaCadastra().getPTipo()){
            try{
                AdministradorCriaAtividadeEntity administradorCriaAtividadeEntity = new AdministradorCriaAtividadeEntity();
                administradorCriaAtividadeEntity.setAcaIdAtividade(atividadeEntity);
                administradorCriaAtividadeEntity.setAcaIdAdministrador(atividadeEntity.getAPessoaCadastra());
                administradorCriaAtividadeRepository.save(administradorCriaAtividadeEntity);
            }catch (Exception e){
                throw new RuntimeException("Erro ao salvar a atividade em administrador cadastra atividade : " + e.getMessage());
            }

        }

        if(TipoPessoa.COORDENADOR == atividadeEntity.getAPessoaCadastra().getPTipo()){
            try{
                CoordenadorCriaAtivadeEntity coordenadorCriaAtivadeEntity = new CoordenadorCriaAtivadeEntity();
                coordenadorCriaAtivadeEntity.setCcaIdAtividade(atividadeEntity);
                coordenadorCriaAtivadeEntity.setCcaIdCoordenador(atividadeEntity.getAPessoaCadastra());
                coordenadorCriaAtividadeRepository.save(coordenadorCriaAtivadeEntity);
            }catch (Exception e){
                throw new RuntimeException("Erro ao salvar atividade em coordenador cadastra atividade : " + e.getMessage());
            }

        }

    }
}
