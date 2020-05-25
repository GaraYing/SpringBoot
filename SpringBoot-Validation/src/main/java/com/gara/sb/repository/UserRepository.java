package com.gara.sb.repository;

import com.gara.sb.anntation.SecondLevelRepository;

@SecondLevelRepository(value = "userRepository")
//@Component(value = "userRepository")
public class UserRepository {

    public UserRepository() {
        System.out.println("============ userRepository is Constructed");
    }
}
