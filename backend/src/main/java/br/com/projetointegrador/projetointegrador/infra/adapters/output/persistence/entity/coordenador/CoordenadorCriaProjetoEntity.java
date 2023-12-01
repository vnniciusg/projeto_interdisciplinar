package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.coordenador;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_coordenador_cria_projeto")
@Entity(name = "CoordenadorCriaProjetoEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoordenadorCriaProjetoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ccpId;


    @ManyToOne
    @JoinColumn(name = "coordenador_id")
    private PessoaEntity ccpIdCoordenador;


    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private ProjetoEntity ccpIdProjeto;

}

