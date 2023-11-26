package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity;

import br.com.projetointegrador.projetointegrador.domain.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "tb_atividade")
@Entity(name = "AtividadeEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AtividadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "projeto_id")
    private UUID id_projeto;

    private String descricao;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "pessoa_cadastra_id", referencedColumnName = "id")
    private User id_pessoa_cadastra;
}
