package com.omer.springpro6.chapter3.autowiring.yetanotherpickle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ComponentScan
public class AutowiringCfg {

    @Bean @Primary
    public Foo fooImplOne(){
        return new FooImplOne();
    }

    @Bean
    public Foo fooImplTwo(){
        return new FooImplTwo();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public TrickyTarget trickyTarget(){
        return new TrickyTarget();
    }
}

