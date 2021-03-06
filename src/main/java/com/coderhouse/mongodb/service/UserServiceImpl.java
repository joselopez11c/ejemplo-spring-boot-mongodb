package com.coderhouse.mongodb.service;

import com.coderhouse.mongodb.model.User;
import com.coderhouse.mongodb.repository.UserRepository;
import com.coderhouse.mongodb.repository.UserTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserTemplateRepository template;

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

    @Override
    public List<User> findByAgeGreaterThan(int age) {
        return repository.findByAgeGreaterThan(age);
    }

    @Override
    public List<User> findByAgeOrderByNameDesc(int age) {
        return repository.findByAgeOrderByNameDesc(age);
    }

    @Override
    public void updateFirstUsersPhoneByAge(User user, int age) {
//        var query = new Query();
//        query.addCriteria(Criteria.where("age").is(age));
//        var update = new Update();
//        update.set("phone", user.getPhone());
//        template.updateMulti(query, update, User.class);
    }

    @Override
    public List<User> findAllAllByAgeSortedLimit(String country, String orderBy, int limit) {
        return template.findAllAllByAgeSortedLimit(country, orderBy, limit);
    }

}