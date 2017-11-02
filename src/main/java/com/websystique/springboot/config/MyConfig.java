package com.websystique.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Biao on 02/11/2017.
 */
@Component
@PropertySource("classpath:application-local.properties")
public class MyConfig {

    @Value("${backend.environment}")
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
