package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.administrador;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.ProjetoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_administrador_cria_projeto")
@Entity(name = "AdministradorCriaProjetoEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorCriaProjetoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long acprID;


    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private PessoaEntity acpridAdministrador;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private ProjetoEntity acprIdProjeto;

}
