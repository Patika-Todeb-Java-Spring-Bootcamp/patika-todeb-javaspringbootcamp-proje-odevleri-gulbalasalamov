package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //WebSecurityConfigurer creates beans, makes configs, gets https... creates auth layer

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable(); // prevent others accessing your tokens and make requests by using links
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // no session will be created or used by Spring security

        //Entry points
        http.authorizeRequests()
                .antMatchers("/v1/buyer/**").permitAll()
                .antMatchers("/v1/item/**").permitAll()
                .antMatchers("/v1/category/**").permitAll()
                .antMatchers("/v1/order/**").permitAll()
                .anyRequest()
                .authenticated(); // authenticate means no role is important. login enough

//        http
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/xxx").permitAll() // no login necassary. let everyone access this endpoint. for exp login page
//                .antMatchers(HttpMethod.GET, "/v1/buyer/**").hasRole("USER")// to which url who will access and do what. **-> all metods
//                .antMatchers(HttpMethod.POST, "/v1/item/**").hasRole("ADMIN")
//                .and()
//                .csrf().disable();

        //Apply jwt
        //http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));


    }
}
