package com.omer.iocanddi.chapter3.aliasannotation;

import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;

public class AliasExample {

    public static void main(String[] args) {
        Class<Player> playerClass = Player.class;
        // Player sınıfı üzerindeki tüm anotasyonları alalım
        Annotation[] annotations = playerClass.getAnnotations();
        for (Annotation annotation : annotations) {
            // AnnotationUtils kullanarak gerçek 'Award' anotasyonunu bulalım
            Award award = AnnotationUtils.findAnnotation(playerClass, Award.class);

            if (award != null) {
                System.out.println("Player's Award Prizes: " + String.join(", ", award.value()));
            }
        }
    }

}
