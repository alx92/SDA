package org.example;

import org.example.config.AppConfig;
import org.springframework.boot.SpringApplication;

public class ConsumingRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}