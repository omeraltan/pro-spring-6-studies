package com.omer.iocanddi.chapter3.injectionvaluesusingspel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("injectSimpleSpEL")
public class InjectSimpleSpELDemo {

    @Value("#{injectSimpleConfig.name.toUpperCase()}")
    private String name;
    @Value("#{injectSimpleConfig.age + 1}")
    private int age;
    @Value("#{injectSimpleConfig.height}")
    private float height;
    @Value("#{injectSimpleConfig.developer}")
    private boolean developer;
    @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSeconds;

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(InjectSimpleConfig.class,InjectSimpleSpELDemo.class);
        ctx.refresh();
        InjectSimpleSpELDemo simple = (InjectSimpleSpELDemo) ctx.getBean("injectSimpleSpEL");
        System.out.println(simple);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isDeveloper() {
        return developer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }

    @Override
    public String toString() {
        return "InjectSimpleSpELDemo{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", height=" + height +
            ", developer=" + developer +
            ", ageInSeconds=" + ageInSeconds +
            '}';
    }
}
