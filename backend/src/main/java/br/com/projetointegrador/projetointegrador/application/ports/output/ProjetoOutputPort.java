package br.com.projetointegrador.projetointegrador.application.ports.output;

import br.com.projetointegrador.projetointegrador.application.dto.projeto.request.CriarProjetoRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;

import java.util.List;

public interface ProjetoOutputPort {
    Projeto save(CriarProjetoRequestDTO requestDTO);
    List<Projeto> list();
    Boolean delete(Long projetoId);
    Boolean update(Projeto projeto);
}
