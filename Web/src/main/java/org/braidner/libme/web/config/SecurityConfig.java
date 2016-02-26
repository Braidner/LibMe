package org.braidner.libme.web.config;

import org.braidner.libme.core.service.UserService;
import org.braidner.libme.web.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by goodl on 2/26/2016.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected UserDetailsService userDetailsService() {
        return username -> userService.findUser(username);
    }
}
