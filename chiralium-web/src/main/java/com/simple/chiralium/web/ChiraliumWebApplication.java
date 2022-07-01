package com.simple.chiralium.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ChiraliumWeb包启动类
 *
 * @author SimpleZzz
 * @date 2022/06/28 19:12:41
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.simple"})
public class ChiraliumWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChiraliumWebApplication.class,args);
    }
}
