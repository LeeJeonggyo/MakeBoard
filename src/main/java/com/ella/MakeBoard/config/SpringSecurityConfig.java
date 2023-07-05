package com.ella.MakeBoard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.DispatcherType;

@Configuration
public class SpringSecurityConfig {

    /**
     * 비밀번호 encoding
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 로그인 / 로그아웃 처리 관련
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers(
                                new AntPathRequestMatcher("/status")
                                ,new AntPathRequestMatcher("/main")
                                ,new AntPathRequestMatcher("/member/**")
                        ).permitAll()                   // 로그인 없이 접근 가능한 페이지 설정
                        .anyRequest().authenticated()   // 어떠한 요청이라도 인증필요
                )
                .formLogin(login -> login
                        .loginPage("/login")	            // 커스텀 로그인 페이지 지정
                        .loginProcessingUrl("/login-process")	// submit 받을 url
                        .usernameParameter("userId")	        // submit할 아이디
                        .passwordParameter("userPw")	            // submit할 비밀번호
                        .successHandler((request, response, authentication) -> {
                            response.sendRedirect("/boardList");
                        })
                        .failureHandler((request, response, exception) -> {
                            response.sendRedirect("/login");
                        })
                        .permitAll()                            // 대시보드 이동이 막히면 안되므로 얘는 허용
                )
                .logout(logout -> logout.permitAll()
                        .logoutUrl("/logout22")
                        .logoutSuccessHandler((request, response, authentication) -> {
                            response.sendRedirect("/login");
                        }) // 로그아웃 성공 핸들러
                );	// 로그아웃은 기본설정으로 (/logout으로 인증해제)

        return http.build();
    }
}