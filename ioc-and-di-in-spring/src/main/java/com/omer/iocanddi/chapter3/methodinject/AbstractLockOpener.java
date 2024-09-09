package com.omer.iocanddi.chapter3.methodinject;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLockOpener")
public abstract class AbstractLockOpener implements LockOpener {


    @Lookup("keyHelper")
    @Override
    public abstract KeyHelper getMyKeyOpener();

    @Override
    public void openLock() {
        getMyKeyOpener().open();
    }
}

/**
 *
 * Bu kod, Spring Framework kullanılarak yazılmış ve bir soyut sınıf (abstract class) olan AbstractLockOpener'ın yapısını tanımlıyor.
 * Bu sınıf, daha önce bahsettiğiniz LockOpener arayüzünü uyguluyor ve özellikle Spring'in
 * dependency injection (bağımlılık enjeksiyonu) özelliklerinden birini, yani @Lookup anotasyonunu kullanıyor.
 * @Component("abstractLockOpener"):
 * Bu anotasyon, AbstractLockOpener sınıfını Spring'in yönetimindeki bir bileşen (component) olarak tanımlar.
 * "abstractLockOpener" adıyla bir bean olarak Spring konteynerinde yer alır ve bu isimle erişilebilir.
 * @Lookup("keyHelper"):
 * Bu önemli anotasyon, Spring’in prototype scope'lu bean’leri dinamik olarak almasını sağlar.
 * @Lookup("keyHelper") ile Spring'e, getMyKeyOpener() metodunu her çağırdığınızda yeni bir KeyHelper nesnesi döndürmesini söylüyorsunuz.
 * Bu, özellikle prototype scope’lu bileşenlerin her çağrıda yeni bir nesne döndürmesini sağlamak için kullanılır.
 * Yani, her getMyKeyOpener() çağrısında, KeyHelper sınıfının yeni bir örneği oluşturulacak ve bu metod aracılığıyla geri döndürülecektir. Bu sayede KeyHelper nesneleri her kullanımda yeniden üretilir.
 * @Lookup anotasyonu: @Lookup, Spring’in her seferinde yeni bir KeyHelper nesnesi oluşturmasını sağlar.
 * Özellikle prototype scope'lu bean’lerle kullanılır.
 * Bu sınıfın her kullanımında yeni bir KeyHelper nesnesi gerekir ve Spring bu işlemi otomatik olarak yönetir.
 *
 */
