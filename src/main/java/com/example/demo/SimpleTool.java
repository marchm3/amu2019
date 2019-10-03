package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("prod")
public class SimpleTool implements Tool {

    private static Logger logger = LoggerFactory.getLogger(SimpleTool.class);

    @PostConstruct
    public void init() {
        logger.info("Simple tool");
    }
}
