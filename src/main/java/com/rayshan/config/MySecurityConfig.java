package com.rayshan.config;

import com.rayshan.repository.LoginActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class MySecurityConfig {
    private LoginActivityRepository activityRepo;

    @Autowired
    public MySecurityConfig(LoginActivityRepository repo) {
        this.activityRepo = repo;
    }
    private static final String[] AUTH_WHITELIST = {"/api/test/**", "/h2-console", "/h2-console/**"};
    private static final String[] ADMIN_ONLY_URL = {"/api/activities/**"};

    @Bean
    public SecurityFilterChain getSecurityFilter(HttpSecurity http) throws Exception{
        http.formLogin();
        //http.httpBasic();
        //http.authorizeRequests().anyRequest().permitAll();

        // ---- Enable this -----
        http.authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers(ADMIN_ONLY_URL).hasRole("ADMIN")
                .anyRequest().authenticated();

        // Without disabling CSRF, you will get 403 for POST/PUT/DELETE calls.
        http.csrf().disable().cors(); // To allow POST/PUT/DELETE
        http.headers().frameOptions().disable(); // This is required to access H2 Console.
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService2() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, user1);
    }
}
