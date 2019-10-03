package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ScopesShowcase {
    private static Logger logger = LoggerFactory.getLogger(ScopesShowcase.class);

    @Autowired
    private PrototypeBean prototypeBean;

    @Autowired
    private SingletonBean singletonBean;

    @Autowired
    ApplicationContext appCxt;

    @PostConstruct
    private void init() {
        showcase();
        showcase();
    }

    private void showcase() {
        logger.info(getPrototypeBean().toString());
        logger.info(getSingletonBean().toString());
    }

    private PrototypeBean getPrototypeBean() {
        return appCxt.getBean(PrototypeBean.class);
    }

    private SingletonBean getSingletonBean() {
        return appCxt.getBean(SingletonBean.class);
    }
}
