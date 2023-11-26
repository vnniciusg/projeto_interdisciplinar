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
public class Projeto {
    private UUID id;
    private String nome;
    private String recurso;
    private String objetivo;
    private User id_pessoa_coordena;
    private User id_pessoa_cadastra;
}
