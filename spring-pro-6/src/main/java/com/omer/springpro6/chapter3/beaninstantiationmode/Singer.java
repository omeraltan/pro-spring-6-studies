package com.omer.springpro6.chapter3.beaninstantiationmode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("nonSingleton")
@Scope(scopeName = "prototype")
public class Singer {

    private String name = "unknown";

    public Singer(@Value("John Mayer") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Singer{" +
            "name='" + name + '\'' +
            '}';
    }
}
