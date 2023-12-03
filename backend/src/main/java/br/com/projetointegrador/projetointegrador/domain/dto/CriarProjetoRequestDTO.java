package br.com.projetointegrador.projetointegrador.domain.dto;

import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriarProjetoRequestDTO{
    @JsonProperty("prNome")
    private String prNome;

    @JsonProperty("prRecursos")
    private String prRecursos;

    @JsonProperty("prObjetivo")
    private String prObjetivo;

    @JsonProperty("prIdPessoaCoordena")
    private Long prIdPessoaCoordena;

    @JsonProperty("prIdPessoaCadastra")
    private Long prIdPessoaCadastra;
}
