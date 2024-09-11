package com.omer.iocanddi.chapter3.aliasannotation;

import org.springframework.core.annotation.AliasFor;

@Award
public @interface Trophy {

    @AliasFor(annotation = Award.class, attribute = "value")
    String[] name() default {};

}
