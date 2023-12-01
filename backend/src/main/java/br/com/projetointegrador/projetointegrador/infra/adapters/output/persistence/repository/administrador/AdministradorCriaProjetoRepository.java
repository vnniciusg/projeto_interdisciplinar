package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.administrador;

import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.administrador.AdministradorCriaProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorCriaProjetoRepository extends JpaRepository<AdministradorCriaProjetoEntity , Long> {
}
