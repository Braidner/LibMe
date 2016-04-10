package org.braidner.libme.web.config;

import org.braidner.libme.core.model.User;
import org.braidner.libme.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

import java.util.Collections;

/**
 * Created by goodl on 2/26/2016.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private User anon;

    @Override
    protected UserDetailsService userDetailsService() {
        return userService::findUser;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
                .and().formLogin().loginPage("/login").permitAll()
                .and().httpBasic()
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService::findUser)
//                .passwordEncoder(new BCryptPasswordEncoder())
        ;
    }

    @Bean
    public User anon() {
        User user = new User();
        user.setLogin("anon");
        return user;
    }

    @Bean
    public AnonymousAuthenticationFilter anonymousFilter() {
        return new AnonymousAuthenticationFilter("anon", anon, Collections.singletonList(() -> "ROLE_ANONYMOUS"));
    }

    @Bean
    public AnonymousAuthenticationProvider anonymousProvider() {
        return new AnonymousAuthenticationProvider("anon");
    }

    @Bean
    public AnonymousAuthenticationToken anonymousToken() {
        return new AnonymousAuthenticationToken("anon", anon, Collections.singletonList(() -> "ROLE_ANONYMOUS"));
    }
}
