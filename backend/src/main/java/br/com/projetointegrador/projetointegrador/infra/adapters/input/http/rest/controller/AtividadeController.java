package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.controller;

import br.com.projetointegrador.projetointegrador.application.ports.input.AtividadeUseCase;
import br.com.projetointegrador.projetointegrador.domain.dto.CriarAtividadeRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atividades")
@RequiredArgsConstructor
public class AtividadeController {

    private final AtividadeUseCase atividadeUseCase;
    private final TokenService tokenService;

    @Transactional
    @PostMapping
    public ResponseEntity<?> criarAtividade(@RequestHeader("Authorization") String token ,@RequestBody @Validated  CriarAtividadeRequestDTO requestDTO){
        try{
            Long id = tokenService.extractIdAndConvertToNumber(token);
            requestDTO.setAIdPessoaCadastra(id);
            atividadeUseCase.criarAtividade(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao criar a atividade : " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarAtiidades(){
        try{
            List<Atividade> atividades = atividadeUseCase.listarAtividades();
            return ResponseEntity.ok().body(atividades);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao listar atividades : " + e.getMessage());
        }
    }
}
