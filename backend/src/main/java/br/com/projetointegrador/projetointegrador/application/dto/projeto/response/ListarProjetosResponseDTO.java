package br.com.projetointegrador.projetointegrador.application.dto.projeto.response;

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
