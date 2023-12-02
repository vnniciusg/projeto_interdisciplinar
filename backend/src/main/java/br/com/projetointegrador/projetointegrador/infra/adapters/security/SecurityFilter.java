package br.com.projetointegrador.projetointegrador.infra.adapters.security;

import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity.PessoaEntity;
import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.PessoaRepository;
import br.com.projetointegrador.projetointegrador.infra.adapters.token.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final PessoaRepository pessoaRepository;

    public SecurityFilter(TokenService tokenService, PessoaRepository pessoaRepository) {
        this.tokenService = tokenService;
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = tokenService.recuperarTokenDoHeaderAuthorization(request);
        if (tokenJWT != null){
            var subject = tokenService.getSubject(tokenJWT);
            var pessoaToken = pessoaRepository.findById(Long.parseLong(subject));
            if(pessoaToken.isEmpty()){
                return;
            }
            Collection<? extends GrantedAuthority> authorities = pessoaToken.get().getAuthorities();
            PessoaEntity pessoa = pessoaToken.get();
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(pessoa.getPCpf(), pessoa.getPSenha(),authorities);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request,response);
    }
}
