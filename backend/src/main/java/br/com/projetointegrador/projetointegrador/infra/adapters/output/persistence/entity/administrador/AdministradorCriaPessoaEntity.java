package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.administrador;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "tb_administrador_cria_pessoa")
@Entity(name = "AdministradorCriaPessoaEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorCriaPessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long acpId;

    @ManyToOne
    @JoinColumn(name = "admnistrador_id")
    private PessoaEntity acpIdAdministrador;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity acpIdPessoa;

}

