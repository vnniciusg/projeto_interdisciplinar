package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.controller;

import br.com.projetointegrador.projetointegrador.application.ports.input.ProjetoUseCase;
import br.com.projetointegrador.projetointegrador.application.dto.projeto.request.CriarProjetoRequestDTO;
import br.com.projetointegrador.projetointegrador.application.dto.projeto.response.ListarProjetosResponseDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Projeto;
import br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.mapper.projeto.ProjetoMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.token.TokenService;
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
    private final ProjetoMapper projetoMapper;
    private final TokenService tokenService;

    @Transactional
    @PostMapping
    public ResponseEntity<?> criarProjeto(@RequestHeader("Authorization") String token,@RequestBody CriarProjetoRequestDTO requestDTO ){
        try {
            Long id = tokenService.extractIdAndConvertToNumber(token);
            requestDTO.setPrIdPessoaCadastra(id);
            projetoUseCase.criarProjeto(requestDTO);
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
                List<ListarProjetosResponseDTO> responseDTOS = projetoMapper.toProjetosResponse(projetos);
                return ResponseEntity.ok().body(responseDTOS);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar projetos: " + e.getMessage());
        }
    }



}
