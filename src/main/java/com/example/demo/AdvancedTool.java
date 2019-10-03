package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
@Profile("prod")
public class AdvancedTool implements Tool {

    private static Logger logger = LoggerFactory.getLogger(AdvancedTool.class);

    @PostConstruct
    public void init() {
        logger.info("Advanced tool");
    }
}
