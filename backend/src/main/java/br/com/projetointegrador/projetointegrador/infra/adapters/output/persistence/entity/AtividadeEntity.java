package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.TipoAtividade;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "tb_atividade")
@Entity(name = "AtividadeEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtividadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long aId;
    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private ProjetoEntity aProjeto;
    private String aDescricao;
    private TipoAtividade aTipo;
    @ManyToOne
    @JoinColumn(name = "pessoa_cadastra_atividade_id")
    private PessoaEntity aPessoaCadastra;
}
