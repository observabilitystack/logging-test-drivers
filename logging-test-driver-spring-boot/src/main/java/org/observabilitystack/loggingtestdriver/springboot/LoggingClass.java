package org.observabilitystack.loggingtestdriver.springboot;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingClass {

    static final LoggingClass INSTANCE = new LoggingClass();
    
    final Logger logger = LoggerFactory.getLogger(LoggingClass.class);

    Random random = new Random();
    
    private LoggingClass() {
    }
    
    void log() {
        int nextInt = random.nextInt(100);
        if(nextInt <= 5) {
            logger.error("Something went wrong!", new RuntimeException("Something went wrong!"));
        } else if(nextInt <= 20) {
            logger.warn("Something suspicious has happened");
        } else {
            logger.info("Something interesting has happened");
        }
    }
    
    
}
