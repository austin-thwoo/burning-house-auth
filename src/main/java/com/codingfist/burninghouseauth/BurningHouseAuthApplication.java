package com.codingfist.burninghouseauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@Configuration
@EnableScheduling
@EnableCaching
public class BurningHouseAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurningHouseAuthApplication.class, args);
    }

}
