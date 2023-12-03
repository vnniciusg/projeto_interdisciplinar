package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.mapper.atividade;

import br.com.projetointegrador.projetointegrador.application.dto.atividade.response.ListarAtividadesDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;

import java.util.List;

public interface AtividadeMapper {

        ListarAtividadesDTO toListarAtividadeDTO(Atividade atividade);
        List<ListarAtividadesDTO> toListarAtividadesDTO(List<Atividade> atividades);
}
