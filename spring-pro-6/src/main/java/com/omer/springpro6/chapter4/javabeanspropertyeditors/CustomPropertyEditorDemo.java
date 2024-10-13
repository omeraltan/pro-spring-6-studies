package com.omer.springpro6.chapter4.javabeanspropertyeditors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomPropertyEditorDemo {

    private static Logger logger = LoggerFactory.getLogger(CustomPropertyEditorDemo.class);

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(CustomPropertyEditorCfg.class);
        var person = ctx.getBean(Person.class, "person");
        logger.info("Person full name = {}" , person.getName());
        ctx.close();
    }

}
