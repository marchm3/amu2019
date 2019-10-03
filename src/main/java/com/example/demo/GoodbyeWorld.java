package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class GoodbyeWorld {

    private static Logger logger = LoggerFactory.getLogger(GoodbyeWorld.class);

    @PreDestroy
    public void destroy() {
        logger.info("Goodbye");
    }
}
