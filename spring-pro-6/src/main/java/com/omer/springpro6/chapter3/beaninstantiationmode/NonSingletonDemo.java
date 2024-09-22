package com.omer.springpro6.chapter3.beaninstantiationmode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NonSingletonDemo {

    private static Logger logger = LoggerFactory.getLogger(BeanNameGeneratorDemo.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(Singer.class);
        ctx.refresh();
        var singer1 = ctx.getBean("nonSingleton", Singer.class);
        var singer2 = ctx.getBean("nonSingleton", Singer.class);

        logger.info("Identity Equal?: " + (singer1 == singer2));
        logger.info("Value Equal:?" + singer1.equals(singer2));

        logger.info(singer1.toString());
        logger.info(singer2.toString());
    }

}
