package com.coderhouse.mongodb.service;

import com.coderhouse.mongodb.model.User;
import com.coderhouse.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtraImplementacion implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private MongoTemplate template;

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findByAgeGreaterThan(int age) {
        return null;
    }

    @Override
    public List<User> findByAgeOrderByNameDesc(int age) {
        return null;
    }

    @Override
    public void updateFirstUsersPhoneByAge(User user, int age) {

    }

    @Override
    public List<User> findAllAllByAgeSortedLimit(String country, String orderBy, int limit) {
        return null;
    }

}