package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.controller;

import br.com.projetointegrador.projetointegrador.application.dto.pessoaTrabalhaEmAtividade.request.CreatePessoaTrabalhaEmAtividadeDTO;
import br.com.projetointegrador.projetointegrador.application.ports.input.PessoaTrabalhaEmAtividadeUseCase;
import br.com.projetointegrador.projetointegrador.infra.adapters.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoaAtividades")
@RequiredArgsConstructor
public class PessoaTrabalhaEmAtividade {

    private final TokenService tokenService;
    private final PessoaTrabalhaEmAtividadeUseCase pessoaTrabalhaEmAtividadeUseCase;

    @Transactional
    @PostMapping
    public ResponseEntity<?> criarPessoaTrabalhaEmAtividade(@RequestHeader String token , @RequestBody CreatePessoaTrabalhaEmAtividadeDTO createPessoaTrabalhaEmAtividadeDTO){
        try{
            if(createPessoaTrabalhaEmAtividadeDTO.getPtaIdPessoa() != null){
                createPessoaTrabalhaEmAtividadeDTO.setPtaIdPessoa(createPessoaTrabalhaEmAtividadeDTO.getPtaIdPessoa());
            }else{
                createPessoaTrabalhaEmAtividadeDTO.setPtaIdPessoa(tokenService.extractIdAndConvertToNumber(token));
            }
            pessoaTrabalhaEmAtividadeUseCase.criarPessoaTrabalhaEmAtividade(createPessoaTrabalhaEmAtividadeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body( e.getMessage());
        }
    }


}
