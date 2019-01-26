package org.observabilitystack.loggingtestdriver.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class LoggingApplication {

    private static final int DEFAULT_LOG_LINES_PER_MINUTE = 60;

    private final static String ENV_LOG_LINES_PER_MINUTE = "LOG_LINES_PER_MINUTE";

    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class, args);
    }

    @Bean
    public Runnable sleeper(Environment env) {
        final Integer logLinesPerMinute = env.getProperty(ENV_LOG_LINES_PER_MINUTE, Integer.class, DEFAULT_LOG_LINES_PER_MINUTE);
        return () -> {
            try {
                Thread.sleep((long) (240_000 * Math.random() / logLinesPerMinute));
            } catch (Exception e) {
                // It is okay to ignore this one ...
            }
        };
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, Runnable sleeper) {
        return args -> {
            new Thread(() -> {
                while (true) {
                    sleeper.run();
                    LoggingClass.INSTANCE.log();
                }
            }).start(); 
            new Thread(() -> {
                while (true) {
                    sleeper.run();
                    LoggingClass.INSTANCE.log();
                }
            }).start(); 
        };
    }

}

