package me.naveenmk.user_test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeHttpRequests((requests) -> requests
//                         .requestMatchers("/", "/home").permitAll()
//                         .anyRequest().authenticated())
//                 .formLogin((form) -> form
//                         .loginPage("/login")
//                         .permitAll())
//                 .logout((logout) -> logout.permitAll());

//         return http.build();
//     }

// }
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import me.naveenmk.user_test.User.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig {

        @Bean
        public UserDetailsService userDetailsService() {
                return new UserDetailsServiceImpl();
        }

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
                DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
                authProvider.setUserDetailsService(userDetailsService());
                authProvider.setPasswordEncoder(passwordEncoder());

                return authProvider;
        }

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests(
                                auth -> auth.requestMatchers("/register", "/js/**", "/css/**")
                                                .permitAll().anyRequest()
                                                .authenticated())
                                .formLogin(login -> login.loginPage("/login").permitAll())
                                .logout(logout -> logout.permitAll());

                return http.build();
        }

}