package com.omer.springpro6.chapter3.beannaming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(nameGenerator = SimpleBeanNameGenerator.class)
public class BeanNamingCfg {


    @Bean
    public SimpleBean anotherSimpleBean() {
        return new SimpleBean();
    }

    // @Bean(name= "simpleBeanTwo")
    // @Bean(value= "simpleBeanTwo")
    @Bean("simpleBeanTwo")
    public SimpleBean simpleBean2() {
        return new SimpleBean();
    }

    // @Bean(name= "simpleBean_tres")
    // @Bean(value= "simpleBean_tres")
    @Bean({"simpleBeanThree", "three", "numero_tres"})
    public SimpleBean simpleBean3() {
        return new SimpleBean();
    }

}
