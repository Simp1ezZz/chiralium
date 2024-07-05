package com.simple.chiralium.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.simple.chiralium"})
public class ChiraliumWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChiraliumWebApplication.class, args);
    }

}
