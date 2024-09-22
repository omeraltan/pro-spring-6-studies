package com.omer.springpro6.chapter3.injectionandapplicationcontextnesting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParentConfig {

    @Bean(name = "parentChildProvider")
    public TitleProvider parentProvider() {
        return TitleProvider.instance(null);
    }

    @Bean(name = "childChildProvider")
    public TitleProvider childProvider() {
        return TitleProvider.instance("Daughters");
    }

}
