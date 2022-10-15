package com.example.LMS.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        http.authorizeRequests().antMatchers("/signup").anonymous();

        //permissions
//        http.authorizeRequests().antMatchers("/refresh_token").permitAll();

        //http.authorizeRequests().antMatchers("/student/{id}/course/{id}").hasAuthority("LECTURER");
//        http.authorizeRequests().antMatchers("/student/**").hasAnyAuthority("STUDENT", "ADMIN");
//
//        http.authorizeRequests().antMatchers("/lecturer/**").hasAnyAuthority("LECTURER", "ADMIN");
//        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
//
//        http.authorizeRequests().antMatchers("/course/add").hasAnyAuthority("LECTURER", "ADMIN");
//        http.authorizeRequests().antMatchers("/course/**").authenticated();

        http.authorizeRequests().anyRequest().authenticated();
//        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
//        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
