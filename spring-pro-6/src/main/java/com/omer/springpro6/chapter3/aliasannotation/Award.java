package com.omer.springpro6.chapter3.aliasannotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Award {
    String[] value() default {};
}
