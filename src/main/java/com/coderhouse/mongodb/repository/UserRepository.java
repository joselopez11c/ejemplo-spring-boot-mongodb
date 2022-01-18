package com.coderhouse.mongodb.repository;

import com.coderhouse.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByName(String name);
    List<User> findByAgeGreaterThan(int age);
    List<User> findByAgeOrderByNameDesc(int age);
}
