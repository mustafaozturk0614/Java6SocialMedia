package com.bilgeadam.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserServiceSecurityConfig {

    @Bean
    JwtTokenFilter getJwtTokenFilter(){
        return new JwtTokenFilter();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable();
    try {
        httpSecurity.authorizeRequests().antMatchers("/swagger-ui/**","/v3/api-docs/**","/api/v1/follow/findall")
                .permitAll().anyRequest().authenticated();

        httpSecurity.addFilterBefore(getJwtTokenFilter(),UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }catch (Exception e){
        e.printStackTrace();
        throw new  RuntimeException();

    }

    }



}
