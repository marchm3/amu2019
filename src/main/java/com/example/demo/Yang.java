package com.example.demo;

import com.sun.tracing.dtrace.Attributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Yang {
    private static Logger logger = LoggerFactory.getLogger(Yang.class);


    private Ying ying;

    @PostConstruct
    private void init() {
        logger.info("yang");
    }

    @Autowired
    private void setYing(Ying ying) {
        logger.info("setYing");
        this.ying = ying;
    }
}
