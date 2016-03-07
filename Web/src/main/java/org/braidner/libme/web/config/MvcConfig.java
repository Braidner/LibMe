package org.braidner.libme.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 05/03/2016
 * Time: 20:04
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
