package br.com.projetointegrador.projetointegrador.application.dto.pessoaTrabalhaEmAtividade.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePessoaTrabalhaEmAtividadeDTO {
    private Long ptaIdAtividade;
    private Long ptaIdPessoa;
    private Date ptpDataInicio;
    private Date ptpDataFim;
}
