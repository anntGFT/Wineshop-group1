package com.gft.wineshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityAdapter{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/regions/create").hasAnyAuthority("ROLE_USER")
                .antMatchers("/api/regions/update").hasAnyAuthority("ROLE_USER")
                .antMatchers("/api/regions/delete").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/api/wine/create").hasAnyAuthority("ROLE_USER")
                .antMatchers("/api/wine/update").hasAnyAuthority("ROLE_USER")
                .antMatchers("/api/wine/delete").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/api/type/create").hasAnyAuthority("ROLE_USER")
                .antMatchers("/api/type/update").hasAnyAuthority("ROLE_USER")
                .antMatchers("/api/type/delete").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/api/winery/create").hasAnyAuthority("ROLE_USER")
                .antMatchers("/api/winery/update").hasAnyAuthority("ROLE_USER")
                .antMatchers("/api/winery/delete").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
                .and()
                .httpBasic();

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