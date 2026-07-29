package com.example.demo_SpringBoot.service;

import java.util.List;

public interface UserServiceInterface {
    User findById(Integer id);

    List<User> findAll();
}
