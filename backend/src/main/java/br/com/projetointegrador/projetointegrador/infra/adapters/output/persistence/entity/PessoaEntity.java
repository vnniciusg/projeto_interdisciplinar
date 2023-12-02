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

    public Long getpID() {
        return pID;
    }

    public void setpID(Long pID) {
        this.pID = pID;
    }

    public String getpRG() {
        return pRG;
    }

    public void setpRG(String pRG) {
        this.pRG = pRG;
    }

    public String getpCpf() {
        return pCpf;
    }

    public void setpCpf(String pCpf) {
        this.pCpf = pCpf;
    }

    public TipoPessoa getpTipo() {
        return pTipo;
    }

    public void setpTipo(TipoPessoa pTipo) {
        this.pTipo = pTipo;
    }

    public String getpSenha() {
        return pSenha;
    }

    public void setpSenha(String pSenha) {
        this.pSenha = pSenha;
    }

    public String getpNome() {
        return pNome;
    }

    public void setpNome(String pNome) {
        this.pNome = pNome;
    }

    public String getpNomeMae() {
        return pNomeMae;
    }

    public void setpNomeMae(String pNomeMae) {
        this.pNomeMae = pNomeMae;
    }

    public String getpNomePai() {
        return pNomePai;
    }

    public void setpNomePai(String pNomePai) {
        this.pNomePai = pNomePai;
    }

    public String getpTelResidencial() {
        return pTelResidencial;
    }

    public void setpTelResidencial(String pTelResidencial) {
        this.pTelResidencial = pTelResidencial;
    }

    public String getpTelRecado() {
        return pTelRecado;
    }

    public void setpTelRecado(String pTelRecado) {
        this.pTelRecado = pTelRecado;
    }

    public PessoaEntity getpPessoaCadastra() {
        return pPessoaCadastra;
    }

    public void setpPessoaCadastra(PessoaEntity pPessoaCadastra) {
        this.pPessoaCadastra = pPessoaCadastra;
    }

    public Date getpDataCriacao() {
        return pDataCriacao;
    }

    public void setpDataCriacao(Date pDataCriacao) {
        this.pDataCriacao = pDataCriacao;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TipoPessoa pTipo;
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
            authorities.add(new SimpleGrantedAuthority(pTipo.name()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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
