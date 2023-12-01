package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity;


import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.TipoPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "Pessoa")
@Table(name = "tb_pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long pID;
    @Column(length = 20)
    private String pRG;
    @Column(length = 14, unique = true)
    private String pCpf;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TipoPessoa pTipo;
    private String pSenha;
    private String pNome;
    private String pNomeMae;
    private String pNomePai;

    @Column(length = 15)
    private String pTelResidencial;

    @Column(length = 15)
    private String pTelRecado;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity pPessoaCadastra;

    @Temporal(TemporalType.TIMESTAMP)
    private Date pDataCriacao;
}
