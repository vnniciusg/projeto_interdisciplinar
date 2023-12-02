package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.controller;

import br.com.projetointegrador.projetointegrador.application.ports.input.PessoaUseCase;
import br.com.projetointegrador.projetointegrador.domain.dto.CriarPessoaDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoas")
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaUseCase pessoaUseCase;
    private final TokenService tokenService;



    @PostMapping
    public ResponseEntity<?> criarPessoa(@RequestBody CriarPessoaDTO requestDTO){
        try{
            Pessoa pessoa = pessoaUseCase.criarPessoa(requestDTO);
            String token = tokenService.gerarToken(pessoa);
            return ResponseEntity.status(HttpStatus.CREATED).header("Authorization", "Bearer " + token).body(pessoa);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao criar pessoa");
        }
    }

    @GetMapping
    public ResponseEntity<?> listarPessoas(){
        try {
            List<Pessoa> pessoas = pessoaUseCase.listarPessoas();
            return ResponseEntity.status(HttpStatus.OK).body(pessoas);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deletarPessoa(@RequestBody Long pessoaId){
        try{
            pessoaUseCase.deletarPessoa(pessoaId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa){
        try{
            Pessoa pessoaAtualizada = pessoaUseCase.atualizarPessoa(pessoa);
            return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
