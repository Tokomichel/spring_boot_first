package com.produit.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests

                        .requestMatchers("/showCreate", "/saveProduit", "/deleteProduit").hasAnyAuthority("ADMIN", "AGENT")
                        .requestMatchers("/ListeProduits").hasAnyAuthority("ADMIN", "AGENT", "USER")
                        .anyRequest().authenticated())

                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }




    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        PasswordEncoder password_encoder = passwordEncoder();

        UserDetails admin = User
                .withUsername("admin")
                .password(password_encoder.encode("123"))
                .authorities("ADMIN")
                .build();
        UserDetails userToko = User
                .withUsername("toko")
                .password(password_encoder.encode("123"))
                .authorities("AGENT", "USER")
                .build();

        UserDetails user1 = User
                .withUsername("user1")
                .password(password_encoder.encode("123"))
                .authorities("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, userToko, user1);
    }
}
