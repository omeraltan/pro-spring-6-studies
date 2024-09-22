package com.omer.springpro6.chapter3.autowiring.yetanotherpickle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class YetAnotherPickleDemo {

    private static Logger logger = LoggerFactory.getLogger(YetAnotherPickleDemo.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AutowiringCfg.class);
        var target = ctx.getBean("trickyTarget",TrickyTarget.class);
        logger.info("target: Created Target? {}", true);
        logger.info("target: Injected bar? {}", target.bar != null);
        logger.info("target: Injected fooOne? {}", target.fooOne != null ? target.fooOne : "");
        logger.info("target: Injected fooTwo? {}", target.fooTwo != null ? target.fooTwo : "");
    }

}
