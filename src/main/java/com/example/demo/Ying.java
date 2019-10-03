package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Ying {
    private static Logger logger = LoggerFactory.getLogger(Ying.class);

    @Autowired
    private Yang yang;

    @PostConstruct
    private void init() {
        logger.info("ying");
    }
}
