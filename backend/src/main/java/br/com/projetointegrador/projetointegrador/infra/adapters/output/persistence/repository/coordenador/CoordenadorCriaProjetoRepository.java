package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.coordenador;

import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.coordenador.CoordenadorCriaProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordenadorCriaProjetoRepository extends JpaRepository<CoordenadorCriaProjetoEntity , Long> {
}
