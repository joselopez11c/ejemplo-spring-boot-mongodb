package com.coderhouse.mongodb.service;

import com.coderhouse.mongodb.model.User;
import com.coderhouse.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}