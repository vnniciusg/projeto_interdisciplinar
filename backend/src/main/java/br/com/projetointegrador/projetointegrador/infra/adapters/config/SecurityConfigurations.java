package br.com.projetointegrador.projetointegrador.infra.adapters.config;

import br.com.projetointegrador.projetointegrador.infra.adapters.config.CorsConfigurations;
import br.com.projetointegrador.projetointegrador.infra.adapters.security.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
@Configuration
@EnableWebMvc
public class SecurityConfigurations {
    @Autowired
    private SecurityFilter securityFilter;

    @Autowired
    private CorsConfigurations corsConfigurations;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurations.corsConfigurationSource()))
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req -> {
                    req.requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll();
                    req.requestMatchers( HttpMethod.POST,"/api/v1/pessoas").permitAll();
                    req.requestMatchers( HttpMethod.POST,"/api/v1/pessoas/login").permitAll();
                    req.requestMatchers(HttpMethod.POST , "/api/v1/atividades").hasAnyAuthority("ROLE_ADMINISTRADOR", "ROLE_COORDENADOR");
                    req.requestMatchers(HttpMethod.POST , "/api/v1/projetos").hasAnyAuthority("ROLE_ADMINISTRADOR", "ROLE_COORDENADOR");
                    req.anyRequest().authenticated();
                })
                .addFilterBefore(securityFilter , UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
