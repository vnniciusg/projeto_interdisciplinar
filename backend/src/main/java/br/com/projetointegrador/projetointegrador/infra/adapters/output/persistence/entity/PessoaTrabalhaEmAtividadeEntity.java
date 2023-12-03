package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "PessoaTabalhaEmAtividadeEntity")
@Table(name = "tb_pessoa_trabalha_em_atividade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaTrabalhaEmAtividadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ptaId;

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private AtividadeEntity ptaAtividade;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity ptaPessoa;

    private Date ptpDataInicio;
    private Date ptpDataFim;

}
