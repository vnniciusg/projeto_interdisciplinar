package br.com.projetointegrador.projetointegrador.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriarProjetoRequestDTO{
    private String prNome;
    private String prRecursos;
    private String prObjetiv;
}
