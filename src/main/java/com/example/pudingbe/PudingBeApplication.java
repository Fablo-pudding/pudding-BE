package com.example.pudingbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@SpringBootApplication()
public class PudingBeApplication {
    public static void main(String[] args) {
        SpringApplication.run(PudingBeApplication.class, args);
    }
}

}
