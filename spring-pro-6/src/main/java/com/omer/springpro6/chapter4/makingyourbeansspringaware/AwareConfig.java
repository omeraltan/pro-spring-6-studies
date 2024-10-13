package com.omer.springpro6.chapter4.makingyourbeansspringaware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AwareConfig {

    @Bean
    NamedSinger johnMayer(){
        return new NamedSinger();
    }

}
