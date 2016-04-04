package org.braidner.libme.web;

import org.braidner.libme.web.config.SecurityConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author KuznetsovNE/ 01.04.2016.
 */
@SpringBootApplication(scanBasePackages = "org.braidner.libme", exclude = {SecurityConfig.class})
@ActiveProfiles(value = "test")
public class TestConfig {
}
