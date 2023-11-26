package br.com.projetointegrador.projetointegrador.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atividade {
    private UUID id;
    private UUID id_projeto;
    private String descricao;
    private String tipo;
    private User id_pessoa_cadastra;
}
