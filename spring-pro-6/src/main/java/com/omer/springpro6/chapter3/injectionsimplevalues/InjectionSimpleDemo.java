package com.omer.springpro6.chapter3.injectionsimplevalues;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("injectSimple")
public class InjectionSimpleDemo {

    @Value("John Mayer")
    private String name;
    @Value("40")
    private int age;
    @Value("1.92")
    private float height;
    @Value("false")
    private boolean developer;
    @Value("1241401112")
    private Long ageInSeconds;

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(InjectionSimpleDemo.class);
        ctx.refresh();

        InjectionSimpleDemo simple = ctx.getBean("injectSimple", InjectionSimpleDemo.class);
        System.out.println(simple);
    }

    @Override
    public String toString() {
        return "InjectionSimpleDemo{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", height=" + height +
            ", developer=" + developer +
            ", ageInSeconds=" + ageInSeconds +
            '}';
    }
}
