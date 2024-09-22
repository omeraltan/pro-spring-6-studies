package com.omer.springpro6.chapter3.autowiring.yetanotherpickle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TrickyTarget {
    private static Logger logger = LoggerFactory.getLogger(TrickyTarget.class);
    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    public TrickyTarget() {
        logger.info(" --> TrickyTarget() called");
    }

    public TrickyTarget(Foo fooOne, Foo fooTwo, Bar bar) {
        this.fooOne = fooOne;
        this.fooTwo = fooTwo;
        this.bar = bar;
    }

    @Autowired
    @Qualifier("fooImplOne")
    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        logger.info(" --> Property fooOne set");
    }
    @Autowired
    @Qualifier("fooImplTwo")
    public void setFooTwo(Foo foo) {
        this.fooTwo = foo;
        logger.info(" --> Property fooTwo set");
    }
    @Autowired
    public void setBar(Bar bar) {
        this.bar = bar;
        logger.info(" --> Property bar set");
    }
}

