package com.mert;

import com.mert.entity.Like;
import com.mert.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class Description {
    /**
     * Burada genel Hibernate anlatımı ve sonraki projelerde kullanılacak repository class oluşturacağız
     */

    /**
     * persist -> ekleme güncelleme
     * id null ise ekleme işlemi yapar, id var ise güncelleme yapar.
     *
     * remove (Entity) -> silme
     */

    /**
     * JDBC -< Connection, statement(SQL),resultset
     * HIBERNATE
     *  1- Connection
     *  2- SQL
     *  3- resultset
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        /**
         * Burada Criteria Builder kullanılarak sorgu oluşturulur.
         * select * from tbluser
         *      1- criteria sorgusu oluşturmak için gerekli olan kolon bilgilerini ve tablo
         *              bilgisini çekmek için kullanacağımız entity sınıfını belirtiriz.
         */
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class); // tbluser bulur
        /**
         *  select * ya da select id,ad,adres gibi sorgu kısmını burada yapıyoruz
         */
        Root<User> root = criteriaQuery.from(User.class);  // tbluser
        criteriaQuery.select(root);  // * select * from kısmını simgeler
     //   criteriaQuery.select(root.get("id")); // * select id from kısmını simgeler

        // Eğer kısıtlama yapacaksak "where" ekleme yapmamız gerekir .
        criteriaQuery.where(criteriaBuilder.equal(root.get("username"),"mert"));
        // Yukarıda username ismi mert olanı getirir.

        criteriaQuery.where(criteriaBuilder.like(root.get("username"),"%m%"));
        // Yukarıda username içinde m harfi gecenleri getirir.

        // User tablosunu listeye atıp çıktı almak için
        List<User> userList = em.createQuery(criteriaQuery).getResultList();
        em.close();
        emf.close();
        System.out.println("Kullanıcı Listesi");
        System.out.println("----------------");
        userList.forEach(System.out::println);


    }



}
