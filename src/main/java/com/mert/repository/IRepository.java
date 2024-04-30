package com.mert.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T,ID> {
    // burada öncelikle Generic type'ları eklememiz gerekiyor.
    // sonrasında gerekli method başlıklarını yazacağız.
    T save(T entity);
    // burada T eklememizin nedeni kayıttan sonra entitylerinin kendisini döndürmemiz daha sağlıklı

    Iterable<T> saveAll(Iterable <T> entities);
    //Iterable: Liste, Set, Map gibi nesnelerin döndürmesine yardımcı olur.

    Optional<T> findById(ID id);
    // Optional: null olabilecek nesnelerin döndürmesine yardımcı olur.

    boolean existsById(ID id);
    // veriler null gelmemeli bunla uğraşamayız , böyle bir kayıt var mı ->> true, false

    List<T> findAll();
    // tüm kayıtları getirir.

    List<T> findByColumnAndValue(String columnName, Object value);
    //value -> String id olabilir, boolean olabilir, int olabilir o yüzden object yazmak en doğrusu

    void deleteById(ID id);
    //Kayıtlar genellikle ID ile silinir.

    //*******************ÖZEL VE ZORLAYICI METHOD **********************
    List<T> findAllByEntity(T entity);
}

/*
Generic Types (<T, ID>):
T: İşlem yapılan veri tipini temsil eder. Bu sayede IRepository arayüzü farklı türdeki veri modelleri için kullanılabilir hale gelir. Örneğin, bir User veya Product sınıfı olabilir.
ID: İşlem yapılan verinin kimlik (ID) tipini temsil eder. Genellikle Integer veya String gibi türler kullanılır.
T save(T entity);
Bu metod, verilen entity'yi veri deposuna kaydeder ve kaydedilen entity'yi geri döndürür. Geri döndürme işlemi, kaydedilen nesnenin son durumunu (örneğin, atanan birincil anahtar ile) elde etmek için kullanılır.
Iterable<T> saveAll(Iterable<T> entities);
Birden fazla entity'yi aynı anda kaydetmek için kullanılır. Iterable, List, Set gibi koleksiyon yapılarının genel bir süper sınıfıdır ve bu metodun farklı koleksiyon türlerini kabul etmesine olanak sağlar.
Optional<T> findById(ID id);
Belirli bir id değerine sahip entity'yi bulmak için kullanılır. Optional sınıfı, sonucun null olma ihtimaline karşı güvenli bir yöntem sağlar. Optional<T> kullanımı, null kontrolü yapılmasını zorunlu kılar ve böylece NullPointerException riskini azaltır.
boolean existsById(ID id);
Verilen id'ye sahip bir entity'nin veritabanında olup olmadığını kontrol etmek için kullanılır. Bu metod, genellikle veri varlığını kontrol ettikten sonra yapılacak işlemler için bir ön kontrol sağlar.
List<T> findByColumnAndValue(String columnName, Object value);
Belirli bir sütun adı ve değeri ile eşleşen tüm entity'leri döndürmek için kullanılır. Object türü kullanmak, farklı veri türlerini (örneğin String, Integer) kabul edebilme esnekliği sağlar.
void deleteById(ID id);
Belirli bir id değerine sahip entity'yi silmek için kullanılır. Bu işlem genellikle veri silme işlemlerinde ID üzerinden yapılır.
List<T> findByEntity(T entity);
Bu metod daha zorlayıcı ve özel bir durum oluşturur çünkü entity'nin tüm özelliklerine göre eşleşme aramak için kullanılır. Bu, genellikle daha karmaşık sorgular gerektirir ve veri tabanı performansını etkileyebilir.
 */