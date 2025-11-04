package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GatewayServiceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GatewayServiceApplication.class, args);
        System.out.println(" auth.service.url = " + context.getEnvironment().getProperty("auth.service.url"));
    }
}
