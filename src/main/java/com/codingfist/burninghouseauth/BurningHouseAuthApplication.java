package com.codingfist.burninghouseauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableJpaAuditing
@Configuration
@EnableScheduling
@EnableCaching
@ComponentScan(basePackages = {"localCommon.provider"})
public class BurningHouseAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurningHouseAuthApplication.class, args);
    }

}
