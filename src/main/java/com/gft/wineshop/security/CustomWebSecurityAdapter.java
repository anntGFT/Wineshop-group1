package com.gft.wineshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityAdapter{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable();
                /*.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/regions/create")
                .hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/api/regions/update/").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();*/

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User
                .withUsername("user")
                .password("{noop}user")
                .roles("USER")
                .build();
        UserDetails admin = User
                .withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();



        return new InMemoryUserDetailsManager(user,admin);
    }
}