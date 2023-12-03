package br.com.projetointegrador.projetointegrador.application.dto.atividade.request;

import br.com.projetointegrador.projetointegrador.domain.model.Atividade.TipoAtividade;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarAtividadeRequestDTO {
    @JsonProperty("aIdProjeto")
    private Long aIdProjeto;

    @JsonProperty("aDescricao")
    private String aDescricao;

    @JsonProperty("aTipo")
    private TipoAtividade aTipo;

    @JsonProperty("aIdPessoaCadastra")
    private Long aIdPessoaCadastra;
}
