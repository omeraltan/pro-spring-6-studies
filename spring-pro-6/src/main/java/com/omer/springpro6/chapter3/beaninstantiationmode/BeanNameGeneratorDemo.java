package com.omer.springpro6.chapter3.beaninstantiationmode;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

import java.util.Locale;
import java.util.UUID;

public class BeanNameGeneratorDemo extends AnnotationBeanNameGenerator {

    @Override
    protected String buildDefaultBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        var beanName = definition.getBeanClassName().substring(definition.getBeanClassName().lastIndexOf(".") + 1).toLowerCase(Locale.ROOT);
        var uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return beanName + '-' + uuid;
    }

}
