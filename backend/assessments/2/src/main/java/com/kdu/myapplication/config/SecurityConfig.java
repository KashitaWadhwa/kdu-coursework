package com.kdu.myapplication.config;

import com.kdu.myapplication.filter.TokenGeneratorFilter;
import com.kdu.myapplication.filter.TokenValidatorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain customDefaultFilter(HttpSecurity http) throws Exception {
        http.
                addFilterAfter(new TokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new TokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(
                        requests -> requests
                        .requestMatchers("/auth/login").permitAll()
                        //.requestMatchers("/getUser").hasAnyRole("BASIC","ADMIN")
                        .requestMatchers("/addUser").hasRole("ADMIN")
                        .requestMatchers("/destination").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .csrf().disable().cors();

        http.sessionManagement(
                session->session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
