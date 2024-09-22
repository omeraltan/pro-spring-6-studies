package com.omer.springpro6.chapter3.beannaming;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class BeanNamingDemo {

    private static Logger logger = LoggerFactory.getLogger(BeanNamingDemo.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(BeanNamingCfg.class);

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }

}
