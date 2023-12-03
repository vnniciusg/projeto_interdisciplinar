package br.com.projetointegrador.projetointegrador.application.dto.atividade.response;

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
public class ListarAtividadesDTO {
    @JsonProperty("aId")
    private Long aId;
    @JsonProperty("prId")
    private Long prId;
    @JsonProperty("prNome")
    private String prNome;
    @JsonProperty("aDescricao")
    private String aDescricao;
    @JsonProperty("aTipo")
    private TipoAtividade aTipo;
    @JsonProperty("pNome")
    private String pNome;
}
