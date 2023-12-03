package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.mapper.atividade;

import br.com.projetointegrador.projetointegrador.application.dto.atividade.response.ListarAtividadesDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AtividadeMapperImpl implements AtividadeMapper{

    @Override
    public ListarAtividadesDTO toListarAtividadeDTO(Atividade atividade) {
        ListarAtividadesDTO listarAtividadesDTO = new ListarAtividadesDTO();
        listarAtividadesDTO.setAId(atividade.getaId());
        listarAtividadesDTO.setADescricao(atividade.getaDescricao());
        listarAtividadesDTO.setATipo(atividade.getaTipo());
        System.out.println(atividade.getaPessoaCadastra());
        listarAtividadesDTO.setPNome(atividade.getaPessoaCadastra().getpNome());
        listarAtividadesDTO.setPrId(atividade.getaProjeto().getPrId());
        listarAtividadesDTO.setPrNome(atividade.getaProjeto().getPrNome());

        return listarAtividadesDTO;
    }

    @Override
    public List<ListarAtividadesDTO> toListarAtividadesDTO(List<Atividade> atividades) {
        return atividades.stream().map(this::toListarAtividadeDTO).collect(Collectors.toList());
    }
}
