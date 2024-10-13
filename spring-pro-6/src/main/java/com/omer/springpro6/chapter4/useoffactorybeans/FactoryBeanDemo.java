package com.omer.springpro6.chapter4.useoffactorybeans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanDemo {
    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(MessageDigestConfig.class);
        MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello World!");
        ctx.close();
    }
}
