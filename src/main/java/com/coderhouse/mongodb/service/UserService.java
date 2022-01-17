package com.coderhouse.mongodb.service;

import com.coderhouse.mongodb.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User findByName(String name);

    List<User> findAll();

}
