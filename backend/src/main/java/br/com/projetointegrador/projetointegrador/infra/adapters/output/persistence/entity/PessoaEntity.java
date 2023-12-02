package br.com.projetointegrador.projetointegrador.infra.adapters.output.persistence.entity;


import br.com.projetointegrador.projetointegrador.domain.model.Pessoa.TipoPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity(name = "Pessoa")
@Table(name = "tb_pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long pID;
    @Column(length = 20)
    private String pRG;
    @Column(length = 14, unique = true)
    private String pCpf;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TipoPessoa pTipo;
    private String pEmail;
    private String pSenha;
    private String pNome;
    private String pNomeMae;
    private String pNomePai;

    @Column(length = 15)
    private String pTelResidencial;

    @Column(length = 15)
    private String pTelRecado;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity pPessoaCadastra;

    @Temporal(TemporalType.TIMESTAMP)
    private Date pDataCriacao;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if(pTipo!=null){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + pTipo.name()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.pSenha;
    }

    @Override
    public String getUsername() {
        return this.pEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
