package com.grinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GrinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrinderApplication.class, args);
    }

}
