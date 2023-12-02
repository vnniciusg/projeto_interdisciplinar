package br.com.projetointegrador.projetointegrador.domain.dto;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.TipoAtividade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarAtividadeRequestDTO {
    private Long aIdProjeto;
    private String aDescricao;
    private TipoAtividade aTipo ;
    private Long aIdPessoaCadastra;
}
