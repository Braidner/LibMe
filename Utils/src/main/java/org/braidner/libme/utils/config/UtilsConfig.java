package org.braidner.libme.utils.config;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 31/01/2016
 * Time: 11:24
 */
@EnableHystrix
@EnableHystrixDashboard
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "org.braidner.libme.utils")
public class UtilsConfig implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(UtilsConfig.class);


    public static void main(String[] args) {
        SpringApplication.run(UtilsConfig.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Utils module loaded");
    }

    @Bean
    public HystrixCommandAspect javanica() {
        return new HystrixCommandAspect();
    }
}
