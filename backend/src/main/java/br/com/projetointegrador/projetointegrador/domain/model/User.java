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
public class User {
    private UUID id;
    private String RG;
    private String CPF;
    private String email;
    private String nome_pai;
    private String nome_mae;

    private String celular;
    private String residencial;
    private String recado;

}
