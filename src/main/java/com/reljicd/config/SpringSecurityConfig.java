package com.reljicd.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.security.servlet.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;
import org.springframework.security.web.access.*;

import javax.sql.*;

/**
 * Spring Security Configuration
 * http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
 * Switches off Spring Boot automatic security configuration
 *
 * @author Dusan
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    /**
     * - roles ADMIN allow to access /admin/**
     * - roles USER allow to access /user/** and /newPost/**
     * - anybody can visit /, /home, /about, /registration, /error, /blog/**, /post/**, /h2-console/**
     * - every other page needs authentication
     * - custom 403 access denied handler
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationProvider authenticationProvider, AccessDeniedHandler accessDeniedHandler) throws Exception {

        return http
            .csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()).disable())
            .formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/home"))
            .authorizeHttpRequests(req -> req
                .requestMatchers("/login", "/home", "/registration", "/error", "/403", "/webjars/**", "/css/**").permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll()
                .anyRequest().authenticated())
            .exceptionHandling(c -> c.accessDeniedHandler(accessDeniedHandler))
            .authenticationProvider(authenticationProvider)
            .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsServiceImpl) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsServiceImpl);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * Configure and return BCrypt password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
