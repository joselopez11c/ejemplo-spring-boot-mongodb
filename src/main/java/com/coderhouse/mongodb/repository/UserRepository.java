package com.coderhouse.mongodb.repository;

import com.coderhouse.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByName(String name);
    List<User> findByAgeGreaterThan(int age);
    List<User> findByAgeOrderByNameDesc(int age);
}
