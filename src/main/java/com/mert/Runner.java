package com.mert;

import com.mert.entity.User;
import com.mert.entity.utility.State;
import com.mert.repository.UserRepository;

public class Runner {
    /**
     * IRepository ile Interface method oluşturuldu.
     * Repository -> IRepository implements edilerek generic method gövdeleri oluşturuldu.
     * UserRepository -->> Repository'den extends (miras) alarak tüm methodları kullanacağız.
     * Önce User ekleyelim.
     */



    // SAdece username değiştiriyorum.
    /*
    merto
    yigido
    aile
    mutluluk
    sağlık
    araba
    ev
     */
    public static void main(String[] args) {
        User user = User.builder()
                .username("m")
//                .phone("55555")
//                .email("mert@gmail.com")
//                .password("12345")
//                .state(State.ACTIVE)
                .build();

        UserRepository userRepository = new UserRepository();
     //   userRepository.save(user);
        userRepository.findAllByEntity(user).forEach(System.out::println);
        System.out.println("**************************");
        userRepository.findAll().forEach(System.out::println);
        System.out.println("Ekleme başarılı");
    }
}
