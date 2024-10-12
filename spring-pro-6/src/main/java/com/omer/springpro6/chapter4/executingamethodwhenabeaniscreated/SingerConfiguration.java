package com.omer.springpro6.chapter4.executingamethodwhenabeaniscreated;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingerConfiguration {

    //@Bean(initMethod = "init")
    @Bean
    Singer singerOne(){
        Singer singer = new Singer();
        singer.setName("John Mayer");
        singer.setAge(43);
        return singer;
    }

    //@Bean(initMethod = "init")
    @Bean
    Singer singerTwo(){
        Singer singer = new Singer();
        singer.setAge(42);
        return singer;
    }

    //@Bean(initMethod = "init")
    @Bean
    Singer singerThree(){
        Singer singer = new Singer();
        singer.setName("John Butler");
        singer.setAge(45);
        return singer;
    }

}
