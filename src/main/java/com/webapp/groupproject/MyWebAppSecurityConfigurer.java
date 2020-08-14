/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject;

import com.webapp.groupproject.services.MyUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author alexk
 */

@EnableWebSecurity
public class MyWebAppSecurityConfigurer extends WebSecurityConfigurerAdapter {

   @Autowired
   MyUserServiceInterface myUserServiceInterface;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    
     @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .antMatchers("/").hasAnyRole("ADMIN", "USER")
               .antMatchers("/quiz/**").hasAnyRole("ADMIN", "USER")
               .and()
               .formLogin()
               .loginPage("/loginPage").permitAll()
               .and()
               .logout().permitAll();
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(myUserServiceInterface);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
    
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
