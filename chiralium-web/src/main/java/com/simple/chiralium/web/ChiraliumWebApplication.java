package com.simple.chiralium.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * ChiraliumWeb包启动类
 *
 * @author SimpleZzz
 * @date 2022/06/28 19:12:41
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.simple.chiralium"})
@EnableJpaRepositories(basePackages = {"com.simple.chiralium"})
@EntityScan(basePackages = {"com.simple.chiralium"})
@EnableJpaAuditing
public class ChiraliumWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChiraliumWebApplication.class,args);
    }
}
