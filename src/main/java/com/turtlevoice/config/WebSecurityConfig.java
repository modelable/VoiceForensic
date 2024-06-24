package com.turtlevoice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private static final String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/about/**",
            "/contact/**",
            "/error/**",
            "/console/**"
    };
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //접근 제어
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(PUBLIC_MATCHERS).permitAll()  //이건 허용
                        .requestMatchers("/**").authenticated()
                        .requestMatchers("/", "/home", "/signup").permitAll()  //허용
                        .requestMatchers("/register").not().fullyAuthenticated()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                //login 설정
                .formLogin(formLogin -> formLogin
                         .loginPage("/login")
                        .defaultSuccessUrl("/home")
                        .failureUrl("/login?error")
                        .permitAll()
                )
                //logout 설정
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                //예외발생시
                .exceptionHandling(exceptions -> exceptions
                        .accessDeniedPage("/accessDenied")
                );
        //기본적으로 csrf가 활성화되어 있음
               /* .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/**"));*/

        return http.build();
    }
}
