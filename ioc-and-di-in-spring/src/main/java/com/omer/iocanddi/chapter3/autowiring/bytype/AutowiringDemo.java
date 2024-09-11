package com.omer.iocanddi.chapter3.autowiring.bytype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class AutowiringDemo {

    private static Logger logger = LoggerFactory.getLogger(AutowiringDemo.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AutowiringCfg2.class);
        var anotherTarget = ctx.getBean(AnotherTarget.class);
        logger.info("anotherTarget: Created anotherTarget? {}", anotherTarget !=null);
        logger.info("anotherTarget: Injected bar? {}", anotherTarget.bar != null);
        logger.info("anotherTarget: Injected fooOne? {}", anotherTarget.fooOne != null ? anotherTarget.fooOne.id : "");
        logger.info("anotherTarget: Injected fooTwo? {}", anotherTarget.fooTwo != null ? anotherTarget.fooTwo.id : "");
    }


}

@Configuration
@ComponentScan
class AutowiringCfg2 {

}

@Component
@Lazy
class AnotherTarget{
    private static Logger logger = LoggerFactory.getLogger(AnotherTarget.class);

    Foo2 fooOne;
    Foo2 fooTwo;
    Bar2 bar;

    @Autowired
    public void setFooOne(Foo2 fooOne) {
        logger.info(" --> AnotherTarget#setFooOne(Foo2) called");
        this.fooOne = fooOne;
    }

    @Autowired
    public void setFooTwo(Foo2 fooTwo) {
        logger.info(" --> AnotherTarget#setFooTwo(Foo2) called");
        this.fooTwo = fooTwo;
    }

    @Autowired
    public void setBar(Bar2 bar) {
        logger.info(" --> AnotherTarget#setBar(Bar2) called");
        this.bar = bar;
    }
}

@Component
class Foo2{
    String id = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
}

@Component
class Bar2{

}
