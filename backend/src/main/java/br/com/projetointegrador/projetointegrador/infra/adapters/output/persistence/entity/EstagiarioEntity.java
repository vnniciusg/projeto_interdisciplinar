package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_estagiario")
@Entity(name = "EstagiarioEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstagiarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long eId;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity ePessoa;
    private Long eRa;
    private Long ePeriodo;
    private String eCurso;
    private boolean eAcademico;
}
