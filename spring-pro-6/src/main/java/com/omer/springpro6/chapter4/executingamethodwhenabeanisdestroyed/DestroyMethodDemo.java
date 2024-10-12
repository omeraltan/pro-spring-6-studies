package com.omer.springpro6.chapter4.executingamethodwhenabeanisdestroyed;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DestroyMethodDemo {
    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
        ctx.close(); // needed to close the context
    }
}
