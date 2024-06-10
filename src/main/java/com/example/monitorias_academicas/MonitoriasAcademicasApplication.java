package com.example.monitorias_academicas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MonitoriasAcademicasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoriasAcademicasApplication.class, args);
    }

}
