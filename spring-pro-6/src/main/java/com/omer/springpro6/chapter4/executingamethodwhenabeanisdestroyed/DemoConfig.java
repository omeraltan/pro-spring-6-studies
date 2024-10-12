package com.omer.springpro6.chapter4.executingamethodwhenabeanisdestroyed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean(destroyMethod = "destroyMethod")
    FileManager fileManager() {
        return new FileManager();
    }

}
