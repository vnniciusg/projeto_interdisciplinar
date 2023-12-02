package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.controller.Pessoa;

import br.com.projetointegrador.projetointegrador.application.ports.input.PessoaUseCase;
import br.com.projetointegrador.projetointegrador.domain.dto.CriarPessoaDTO;
import br.com.projetointegrador.projetointegrador.domain.dto.LoginDTO;
import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.Pessoa;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.mapper.pessoa.PessoaPersistenceMapper;
import br.com.projetointegrador.projetointegrador.infra.adapters.token.TokenJWTData;
import br.com.projetointegrador.projetointegrador.infra.adapters.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoas")
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaUseCase pessoaUseCase;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager manager;
    private final PessoaPersistenceMapper pessoaPersistenceMapper;


    @Transactional
    @PostMapping
    public ResponseEntity<?> criarPessoa(@RequestBody CriarPessoaDTO requestDTO){
        try{
            String hashedPassword = passwordEncoder.encode(requestDTO.getPSenha());
            requestDTO.setPSenha(hashedPassword);
            Pessoa pessoa = pessoaUseCase.criarPessoa(requestDTO);
            String token = tokenService.gerarToken(pessoa.getpID());
            return ResponseEntity.status(HttpStatus.CREATED).body(new TokenJWTData(token));
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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
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

    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody LoginDTO data){
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(data.getPEmail() , data.getPSenha());
            Authentication authentication = this.manager.authenticate(usernamePasswordAuthenticationToken);
            var pessoaEntity = (PessoaEntity) authentication.getPrincipal();
            var tokenJWT = tokenService.gerarToken(pessoaEntity.getPID());
            return ResponseEntity.ok().body(new TokenJWTData(tokenJWT));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
