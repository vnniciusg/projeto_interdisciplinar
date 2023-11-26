package br.com.projetointegrador.projetointegrador.application.ports.output;

import br.com.projetointegrador.projetointegrador.domain.model.Projeto;

import java.util.List;
import java.util.UUID;

public interface ProjetoOutputPort {
    Projeto save(Projeto Projeto);
    List<Projeto> list();
    Boolean delete(UUID projeto_ID);

    Boolean update(UUID projeto_ID , Projeto projeto);
}
