package com.omer.iocanddi.methodinject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("standardLockOpener")
public class StandardLockOpener implements LockOpener {

    private KeyHelper keyHelper;

    @Autowired
    @Qualifier("keyHelper")
    public void setKeyHelper(KeyHelper keyHelper) {
        this.keyHelper = keyHelper;
    }


    @Override
    public KeyHelper getMyKeyOpener() {
        return keyHelper;
    }

    @Override
    public void openLock() {
        keyHelper.open();
    }
}

/**
 *
 * @Component("standardLockOpener"):
 * Bu anotasyon, StandardLockOpener sınıfını bir Spring bileşeni (component) olarak tanımlar.
 * "standardLockOpener" adıyla bir bean olarak Spring'in yönetimi altına girer ve bu isimle Spring konteyneri içinde referans gösterilebilir.
 *
 * @Autowired @Qualifier("keyHelper"):
 * Bu iki anotasyon, dependency injection yoluyla KeyHelper nesnesinin setKeyHelper metodu aracılığıyla enjekte edilmesini sağlar.
 * @Autowired: Spring, uygun bir KeyHelper nesnesi bulur ve bu metot aracılığıyla enjekte eder.
 * @Qualifier("keyHelper"): Hangi KeyHelper bileşeninin enjekte edileceğini belirtir. Eğer Spring'te birden fazla KeyHelper bean tanımlıysa,
 * "keyHelper" adıyla tanımlanmış olanın enjekte edilmesini sağlar.
 * Bu, qualifier ile belirli bir bean'i seçme yöntemidir.
 *
 */
