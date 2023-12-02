package br.com.projetointegrador.projetointegrador.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    @JsonProperty("pEmail")
    private String pEmail;

    @JsonProperty("pSenha")
    private String pSenha;
}
