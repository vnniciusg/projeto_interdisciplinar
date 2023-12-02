package br.com.projetointegrador.projetointegrador.infra.adapters.input.http.rest.controller.Pessoa;

import br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.repository.PessoaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PessoaDetailsService implements UserDetailsService {
    private final PessoaRepository pessoaRepository;
    public PessoaDetailsService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String pEmail) throws UsernameNotFoundException {
        return pessoaRepository.findBypEmail(pEmail);
    }
}
