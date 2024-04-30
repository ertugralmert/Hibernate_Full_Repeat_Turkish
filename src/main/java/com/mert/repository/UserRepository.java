package com.mert.repository;

import com.mert.entity.User;

public class UserRepository extends Repository<User, Long> {
    public UserRepository() {
        super(new User());
    }
    // IRepository ile oluşturduğumuz interface methodları
    // Repository'ye implements ettik
    // şimdi extends ile Repositoryden miras alıp tek kodla bu methodları kullanacağız.
}
