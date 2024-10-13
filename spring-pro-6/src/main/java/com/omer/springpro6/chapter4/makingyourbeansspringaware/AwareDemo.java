package com.omer.springpro6.chapter4.makingyourbeansspringaware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareDemo {

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(AwareConfig.class);
        ctx.registerShutdownHook();
        var singer = ctx.getBean(NamedSinger.class);
        singer.sing();
    }

}
