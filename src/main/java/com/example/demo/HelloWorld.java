package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloWorld {

    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @PostConstruct
    public void init() {
        logger.info("Hello world");
    }
}
