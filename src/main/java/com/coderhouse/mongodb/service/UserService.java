package com.coderhouse.mongodb.service;

import com.coderhouse.mongodb.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User findByName(String name);
    List<User> findAll();
    List<User> findByAgeGreaterThan(int age);
    List<User> findByAgeOrderByNameDesc(int age);
    void updateFirstUsersPhoneByAge(User user, int age);
    List<User> findAllAllByAgeSortedLimit(String country, String orderBy, int limit);
}
