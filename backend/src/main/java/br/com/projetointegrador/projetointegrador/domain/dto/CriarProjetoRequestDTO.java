package br.com.projetointegrador.projetointegrador.domain.dto;

import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;

public record CriarProjetoRequestDTO(
        String prNome,
        String prRecursos,
        String prObjetivo
) {
}
