package com.example.studyolle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector handlerMappingIntrospector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder =
                new MvcRequestMatcher
                        .Builder(handlerMappingIntrospector);
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(mvcMatcherBuilder.pattern("/")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/login")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/sign-up")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/check-email")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/check-email-token")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/email-login")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/check-email-login")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/login-link")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET,"/profile/*")).permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
