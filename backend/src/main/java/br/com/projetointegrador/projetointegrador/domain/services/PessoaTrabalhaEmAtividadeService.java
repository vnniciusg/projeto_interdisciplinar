package br.com.projetointegrador.projetointegrador.domain.services;

import br.com.projetointegrador.projetointegrador.application.dto.pessoaTrabalhaEmAtividade.request.CreatePessoaTrabalhaEmAtividadeDTO;
import br.com.projetointegrador.projetointegrador.application.ports.input.PessoaTrabalhaEmAtividadeUseCase;
import br.com.projetointegrador.projetointegrador.application.ports.output.PessoaTrabalhaEmAtividadeOutputPort;
import br.com.projetointegrador.projetointegrador.domain.model.PessoaTrabalhaEmAtividade;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PessoaTrabalhaEmAtividadeService implements PessoaTrabalhaEmAtividadeUseCase {

    private final PessoaTrabalhaEmAtividadeOutputPort pessoaTrabalhaEmAtividadeOutputPort;

    @Override
    public PessoaTrabalhaEmAtividade criarPessoaTrabalhaEmAtividade(CreatePessoaTrabalhaEmAtividadeDTO createPessoaTrabalhaEmAtividadeDTO) {
        return pessoaTrabalhaEmAtividadeOutputPort.criarPessoaTrabalhaEmAtividade(createPessoaTrabalhaEmAtividadeDTO);
    }
    @Override
    public List<PessoaTrabalhaEmAtividade> listarPessoaTrabalhaEmAtividade(){return pessoaTrabalhaEmAtividadeOutputPort.listarPessoaTrabalhaEmAtividade();}


}
