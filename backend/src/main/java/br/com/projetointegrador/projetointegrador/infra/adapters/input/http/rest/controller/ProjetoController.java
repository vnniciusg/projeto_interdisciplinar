package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.controller;

import br.com.projetointegrador.projetointegrador.application.ports.input.ProjetoUseCase;
import br.com.projetointegrador.projetointegrador.domain.dto.CriarProjetoRequestDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoUseCase projetoUseCase;
    @Transactional
    @PostMapping
    public ResponseEntity<?> criarProjeto(@RequestBody CriarProjetoRequestDTO projetoRequestDTO ){
        try {
            Projeto projeto = Projeto.toProjeto(projetoRequestDTO);
            projetoUseCase.criarProjeto(projeto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao criar o projeto: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarProjetos(){
        try{
            List<Projeto> projetos = projetoUseCase.listarProjetos();
            if (projetos.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok().body(projetos);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar projetos: " + e.getMessage());
        }
    }


}
