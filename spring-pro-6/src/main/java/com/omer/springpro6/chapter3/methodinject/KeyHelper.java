package com.omer.springpro6.chapter3.methodinject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("keyHelper")
@Scope("prototype")
public class KeyHelper {

    public void open() {
    }

}

/**
 * @Component("keyHelper"): Bu anotasyon, Spring'e bu sınıfın bir Spring bileşeni olduğunu ve yönetilmesi gerektiğini söylüyor.
 * "keyHelper" ise bu bileşene atanmış olan benzersiz isimdir.
 * Spring bu sınıfın örneğini gerektiğinde bu isimle arar ve kullanır.
 * @Scope("prototype"): Bu anotasyon, Spring'te bu bileşenin prototype scope ile kullanılacağını belirtir.
 * Prototype scope, her talep edildiğinde yeni bir nesne oluşturulmasını sağlar.
 * Yani, KeyHelper sınıfından birden fazla örnek gerektiğinde, Spring her seferinde yeni bir nesne üretir.
 * Bu, singleton'dan farklıdır, çünkü singleton scope'ta sadece tek bir örnek oluşturulur ve her talep edilişte aynı nesne kullanılır.
 */
