package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity;


import br.com.projetointegrador.projetointegrador.domain.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_projeto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    private String recurso;
    private String objetivo;

    @ManyToOne
    @JoinColumn(name = "pessoa_coordena_id", referencedColumnName = "id")
    private User id_pessoa_coordena;

    @ManyToOne
    @JoinColumn(name = "pessoa_cadastra_id", referencedColumnName = "id")
    private User id_pessoa_cadastra;
}
