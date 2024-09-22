package com.omer.springpro6.chapter3.injectioncollections;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollectionInjectionDemo {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(CollectionConfig.class, CollectingBean.class);
        ctx.refresh();

        var collectingBean = ctx.getBean(CollectingBean.class);
        collectingBean.printCollections();
    }
}
