// src/main/java/com/agoraboard/agoraboard/config/SecurityConfig.java
package com.agoraboard.agoraboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class TempSecurityConfig {
    // 개발을 위해 임시로 로컬 서버를 개방하는 설정

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // API 개발 단계에선 일단 비활성화
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/api/**", "/", "/index.html", "/**/*.js", "/**/*.css").permitAll()
                        .anyRequest().permitAll()
                )
                .headers(h -> h.frameOptions(f -> f.disable())) // H2 콘솔용
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
