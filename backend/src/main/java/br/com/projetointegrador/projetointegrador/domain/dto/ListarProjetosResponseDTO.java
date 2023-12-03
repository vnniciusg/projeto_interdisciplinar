package br.com.projetointegrador.projetointegrador.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListarProjetosResponseDTO {
    private Long prId;

    private String prNome;
}
