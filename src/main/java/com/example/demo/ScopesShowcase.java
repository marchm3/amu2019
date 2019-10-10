package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
public class ScopesShowcase {
    public ScopesShowcase() {}

    private ScopesShowcase(Integer a) {
        logger.info("Prywatny Konstruktor");
    }

    private static Logger logger = LoggerFactory.getLogger(ScopesShowcase.class);

    private Integer pole = 5;

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
        logger.info("Konstruktory:");
        for(Constructor c : getClass().getDeclaredConstructors()) {
            logger.info(c.toString());
        }
        logger.info("Pola:");
        for(Field f : getClass().getDeclaredFields()) {
            logger.info(f.toString());
        }
        logger.info("Metody:");
        for(Method m : getClass().getDeclaredMethods()) {
            logger.info(m.toString());
            logger.info("   Parametry:");
            for(Class c : m.getParameterTypes()) {
                logger.info("       " + c.getName());
            }
        }
        try {
            ScopesShowcase ss = getClass().newInstance();
        } catch (Throwable e) {
            logger.error(e.toString());
        }
        createInstance("com.example.demo.ScopesShowcase");
        try {
            Constructor c = getClass().getDeclaredConstructor(Integer.class);
            c.setAccessible(true);
            c.newInstance(5);
            c.setAccessible(false);

            Method m = getClass().getDeclaredMethod("showcase");
            m.setAccessible(true);
            m.invoke(this);
            m.setAccessible(false);

            Field f = getClass().getDeclaredField("pole");
            f.setAccessible(true);
            f.set(this, 7);
            f.setAccessible(false);
        } catch (Throwable e) {
            logger.error(e.toString());
        }

        try {
            DoSerializacji d = new DoSerializacji();

            FileOutputStream f = new FileOutputStream(new File("plik"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(d);

            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("plik"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            DoSerializacji d2 = (DoSerializacji)oi.readObject();

            logger.info(d.test);
            logger.info(d2.test);

            oi.close();
            fi.close();
        } catch (Throwable e) {
            logger.error(e.toString());
        }

    }

    public void createInstance(String className) {
        try {
            Object ss = Class.forName(className).newInstance();
            logger.info(ss.toString());
        } catch (Throwable e) {
            logger.error(e.toString());
        }

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
