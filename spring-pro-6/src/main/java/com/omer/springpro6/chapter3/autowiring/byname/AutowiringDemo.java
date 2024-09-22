package com.omer.springpro6.chapter3.autowiring.byname;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        var target = ctx.getBean(Target.class);
        logger.info("target: Created Target? {}", target != null);
        logger.info("target: Injected bar? {}", target.bar != null);
        logger.info("target: Injected fooOne? {}", target.fooOne != null ? target.fooOne.id : "");
        logger.info("target: Injected fooTwo? {}", target.fooTwo != null ? target.fooTwo.id : "");
    }


}

@Configuration
@ComponentScan
class AutowiringCfg2 {

}

@Component
@Lazy
class Target {
    private static Logger logger = LoggerFactory.getLogger(Target.class);

    Foo3 fooOne;
    Foo3 fooTwo;
    Bar3 bar;

    @Autowired
    public Target(@Qualifier("foo3") Foo3 foo) {
        this.fooOne = foo;
        logger.info(" --> Target(Foo2) called");
    }

    public Target(@Qualifier("foo3") Foo3 foo, Bar3 bar) {
        this.fooOne = foo;
        this.bar = bar;
        logger.info(" --> Target(Foo2, Bar2) called");
    }

}

@Component
@Lazy
class AnotherTarget {

    private static Logger logger = LoggerFactory.getLogger(Target.class);

    Foo3 fooOne;
    Foo3 fooTwo;
    Bar3 bar;

    @Autowired
    public void setFooOne(@Qualifier("foo3") Foo3 fooOne) {
        logger.info(" --> AnotherTarget#setFooOne(Foo3) called");
        this.fooOne = fooOne;
    }

    @Autowired
    public void setFooTwo(@Qualifier("foo3") Foo3 fooTwo) {
        logger.info(" --> AnotherTarget#setFooTwo(Foo3) called");
        this.fooTwo = fooTwo;
    }

    @Autowired
    public void setBar(Bar3 bar) {
        logger.info(" --> AnotherTarget#setBar(Bar3) called");
        this.bar = bar;
    }

}

@Component
@Lazy
class FieldTarget {
    private static Logger logger = LoggerFactory.getLogger(FieldTarget.class);

    @Autowired
    @Qualifier("foo3")
    Foo3 fooOne;
    @Autowired
    @Qualifier("anotherFoo")
    AnotherFoo fooTwo;
    @Autowired
    @Qualifier("bar3")
    Bar3 bar;
}

@Component
class Foo3 {
    String id = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
}

@Component
class AnotherFoo {
    String id = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
}

@Component
class Bar3 {

}
