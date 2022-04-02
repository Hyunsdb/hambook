package com.hyunsdb.hambook.config;

import com.hyunsdb.hambook.constant.Role;
import com.hyunsdb.hambook.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests() //url별 권한 관리 설정 옵션 시작점
                .antMatchers("/","/board/**","/static/**","/css/**","/assets/**","/js/**","/vendor/**").permitAll()
                .antMatchers("/board/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()//로그인 기능에 대한 여러 설정의 진입점
                    .defaultSuccessUrl("/") //로그인 성공시 기본 url
                    .userInfoEndpoint() // 로그인 성공 이후 사용자 정보 가져올 때 설정 담당
                        .userService(customOAuth2UserService); //로그인 성공 시 후속 조치 진행할 UserService 인터페이스 구현체 등록
    }



}
