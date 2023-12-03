package br.com.projetointegrador.projetointegrador.application.dto.auth.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    @JsonProperty("pEmail")
    private String pEmail;

    @JsonProperty("pSenha")
    private String pSenha;
}
