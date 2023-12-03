package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_projeto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prId;
    private String prNome;
    private String prRecursos;
    private String prObjetivo;

    @ManyToOne
    @JoinColumn(name = "pessoa_coordena_projeto_id")
    private PessoaEntity prPessoaCoordena;
    @ManyToOne
    @JoinColumn(name = "pessoa_cadastra_projeto_id")
    private PessoaEntity prPessoaCadastra;
}
