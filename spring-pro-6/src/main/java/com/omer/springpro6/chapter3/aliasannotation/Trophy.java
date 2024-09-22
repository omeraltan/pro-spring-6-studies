package com.omer.springpro6.chapter3.aliasannotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Award
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Trophy {

    @AliasFor(annotation = Award.class, attribute = "value")
    String[] name() default {};

}

/**
 * Burada dikkat etmemiz gereken nokta, name özelliğinin, @AliasFor kullanılarak @Award anotasyonunun prize özelliği ile ilişkilendirilmiş olmasıdır.
 * Yani, @Trophy'de name'e verilen değerler, otomatik olarak @Award'un prize özelliğine aktarılacaktır.
 */
