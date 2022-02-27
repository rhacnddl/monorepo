package com.gorany.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
open class SecurityConfig: WebSecurityConfigurerAdapter() {
    /**
     * 인증이 필요한 페이지를 구분.
     * */
    override fun configure(http: HttpSecurity) {
        http.authorizeHttpRequests()
            .antMatchers("/api/**")
            .permitAll()
            .anyRequest()
            .permitAll()
            .and()
            .httpBasic()

        http.formLogin()
            .and()
            .logout()
    }

    /**
     * 인증 가능한 사용자에 대한 정보 표시
     * */
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password("{noop}12345")
            .authorities("ROLE_ADMIN")
    }
}