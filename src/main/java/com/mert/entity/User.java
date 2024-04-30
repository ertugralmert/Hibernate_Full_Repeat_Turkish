package com.mert.entity;

import com.mert.entity.utility.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //
@AllArgsConstructor //
@NoArgsConstructor // parametreli constructor ların tümü
@Builder //default constructor
@Entity
@Table(name = "tbluser")
public class User {

    /**
     * Burada jakarta yardımı ile gerekli method ve yardımcıları çektik.
     * Bu sayede getter&setter,constructor veya toString gibi ifadelerde kalabalık etmeyeceğiz.
     * Ayrıca DB kısmında column özelliklerini de belirlemiş oluyoruz @Column ile.
     */

    /**
     * DİKKAT ->>>> Enumlar'ın çalışma prensibi:
     * String olarak yazılır ancak default değeri integer olarak çıktı verir.
     * @Enumerated(EnumType.STRING) ile girilen ifadenin String kalmasını sağlarız.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id için otomatik artan HB sequence oluşturur
    Long id;
    @Column (name="user_name", unique = true, nullable = false,length = 70,updatable = false)
    String username;
    @Column (name = "password", nullable =false, length = 30)
    String password;
    @Column (unique = true,nullable = false,length = 70)
    String email;
    @Column(unique = true,nullable = false,length = 12)
    String phone;

    Boolean isActive;
    @Enumerated(EnumType.STRING)
    State state;
}
