package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.coordenador;

import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.coordenador.CoordenadorCriaAtivadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordenadorCriaAtivadeRepository extends JpaRepository<CoordenadorCriaAtivadeEntity , Long> {
}
