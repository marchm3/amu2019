package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Toolbox {

    private static Logger logger = LoggerFactory.getLogger(Toolbox.class);

    @Bean
    @Profile("dev")
    public Tool getTool() {
        return new Tool() {};
    }

    @Autowired
    public List<Tool> tools;

    @PostConstruct
    public void init() {
        logger.info(String.valueOf(tools.size()));
    }
}
