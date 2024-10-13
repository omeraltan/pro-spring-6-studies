package com.omer.springpro6.chapter4.makingyourbeansspringaware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

public class NamedSinger implements BeanNameAware {

    private static Logger logger = LoggerFactory.getLogger(NamedSinger.class);
    private String name;

    @Override /** @Implements {@link BeanNameAware#setBeanName(String)} */
    public void setBeanName(String beanName) {
        this.name = beanName;
    }

    public void sing() {
        logger.info("Singer " + name + " - sing()");
    }
}
