package com.omer.springpro6.chapter4.understandingorderofresolution;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiInitConfiguration {
    @Bean
    Dependency dependency(){
        return new Dependency();
    }

    @Bean(initMethod = "initMe")
    MultiInit multiInitBean(){
        return new MultiInit();
    }

}
