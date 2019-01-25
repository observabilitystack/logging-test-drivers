package org.observabilitystack.loggingtestdriver.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoggingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(500);
                        LoggingClass.INSTANCE.log();
                    } catch (InterruptedException e) {
                        // It is okay to ignore this one ...
                    }
                }
            }).start(); 
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(500);
                        LoggingClass.INSTANCE.log();
                    } catch (InterruptedException e) {
                        // It is okay to ignore this one ...
                    }
                }
            }).start(); 
        };
    }

}

