package com.omer.springpro6.chapter4.understandingorderofresolution;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllInitMethodsDemo {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(MultiInitConfiguration.class);
    }

}
