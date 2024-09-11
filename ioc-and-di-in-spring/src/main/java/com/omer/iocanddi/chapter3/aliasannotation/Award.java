package com.omer.iocanddi.chapter3.aliasannotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Award {
    String[] prize() default {};
}
