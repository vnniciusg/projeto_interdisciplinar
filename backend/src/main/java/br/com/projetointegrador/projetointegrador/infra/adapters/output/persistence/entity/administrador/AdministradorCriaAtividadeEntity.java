package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.administrador;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.AtividadeEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_administrador_cria_atividade")
@Entity(name = "AdministradorCriaAtividadeEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorCriaAtividadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long acaId;

    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private PessoaEntity acaIdAdministrador;

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private AtividadeEntity acaIdAtividade;


}
