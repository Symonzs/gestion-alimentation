package fr.but3.gestion_alimentation.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.DispatcherType;

public class SecurityConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvc = new MvcRequestMatcher.Builder(introspector);
        return http.authorizeHttpRequests((authorize) -> authorize
                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions().disable())
                .build();
    }


@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JdbcUserDetailsManager mesutilisateurs() {
        System.out.println("mesutilisateurs");
        String usersByEmailQuery = "select email, mot_de_passe, True from utilisateur_shas where email = ?";
        String authsByUserQuery = "select email, case when administrateur = true then 'ROLE_ADMIN' else 'ROLE_USER' end as authority from utilisateur_shas where email = ?";

        JdbcUserDetailsManager udm = new JdbcUserDetailsManager(dataSource);

        udm.setUsersByUsernameQuery(usersByEmailQuery);
        udm.setAuthoritiesByUsernameQuery(authsByUserQuery);

        return udm;
    }
}
