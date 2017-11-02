package com.websystique.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Biao on 02/11/2017.
 */
@Component
@ConfigurationProperties(prefix="backend")
public class MyConfig {

    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
