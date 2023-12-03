package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository;

import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaTrabalhaEmAtividadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaTrabalhaEmAtividadeRepository extends JpaRepository<PessoaTrabalhaEmAtividadeEntity, Long> {
}
