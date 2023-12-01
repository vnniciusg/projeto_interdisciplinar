package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.coordenador;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.AtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_coordenador_cria_atividade")
@Entity(name = "CoordenadorCriaAtivadeEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoordenadorCriaAtivadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ccaId;


    @ManyToOne
    @JoinColumn(name = "coordenador_id")
    private PessoaEntity ccaIdCoordenador;


    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private AtividadeEntity ccaIdAtividade;

}
