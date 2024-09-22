package com.omer.springpro6.chapter3.beannaming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ExplicitBeanNamingDemo {

    private static Logger logger = LoggerFactory.getLogger(ExplicitBeanNamingDemo.class);

    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(BeanNamingCfg.class);
        var simpleBeans = ctx.getBeansOfType(SimpleBean.class);
        simpleBeans.forEach((k, v) -> {
            var aliases = ctx.getAliases(k);
            if (aliases.length > 0) {
                logger.debug("Aliases for {} ", k);
                Arrays.stream(aliases).forEach(a -> logger.debug("\t {}", a));
            }
        });
    }

}
