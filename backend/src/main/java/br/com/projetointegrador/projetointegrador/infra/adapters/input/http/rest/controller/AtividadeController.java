package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.controller;

import br.com.projetointegrador.projetointegrador.application.ports.input.AtividadeUseCase;
import br.com.projetointegrador.projetointegrador.application.dto.atividade.request.CriarAtividadeRequestDTO;
import br.com.projetointegrador.projetointegrador.application.dto.atividade.response.ListarAtividadesDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Atividade.Atividade;
import br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.mapper.atividade.AtividadeMapper;
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
    private final AtividadeMapper atividadeMapper;

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
            if (atividades.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                List<ListarAtividadesDTO> responseDTOS = atividadeMapper.toListarAtividadesDTO(atividades);
                return ResponseEntity.ok().body(responseDTOS);
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao listar atividades : " + e.getMessage());
        }
    }

    @GetMapping("/me/atividades")
    public ResponseEntity<?> listarAtividadesPorPessoaCadastra(@RequestHeader("Authorization") String token ){
        try{
            Long id = tokenService.extractIdAndConvertToNumber(token);
            List<Atividade> atividades = atividadeUseCase.listarAtividadesPorPessoaCadastra(id);
            if (atividades.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                List<ListarAtividadesDTO> responseDTOS = atividadeMapper.toListarAtividadesDTO(atividades);
                return ResponseEntity.ok().body(responseDTOS);
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
