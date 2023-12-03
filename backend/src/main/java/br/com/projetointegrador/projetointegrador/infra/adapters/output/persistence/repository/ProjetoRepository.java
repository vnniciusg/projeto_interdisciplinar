package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository;

import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoEntity , Long> {
}
