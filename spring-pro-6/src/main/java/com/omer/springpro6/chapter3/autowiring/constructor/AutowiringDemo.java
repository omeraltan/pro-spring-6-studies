package com.omer.springpro6.chapter3.autowiring.constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class AutowiringDemo {
    private static Logger logger = LoggerFactory.getLogger(AutowiringDemo.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AutowiringCfg.class);
        var target = ctx.getBean(Target.class);

        logger.info("Created target? {}", target != null);
        logger.info("Injected bar? {}", target.bar != null);
        logger.info("Injected fooOne? {}", target.fooOne != null ? target.fooOne.id : "");
        logger.info("Injected fooTwo? {}", target.fooTwo != null ? target.fooTwo.id : "");
    }
}

@Configuration
@ComponentScan
class AutowiringCfg {

}

@Component
@Lazy
class Target {
    private static Logger logger = LoggerFactory.getLogger(Target.class);

    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    public Target() {
        logger.info(" --> Target() called");
    }

    public Target(Foo foo) {
        this.fooOne = foo;
        logger.info(" --> Target(Foo) called");
    }

    public Target(Foo foo, Bar bar) {
        this.fooOne = foo;
        this.bar = bar;
        logger.info(" --> Target(Foo, Bar) called");
    }
}

@Component
class Foo {
    String id = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
}

@Component
class Bar {

}
