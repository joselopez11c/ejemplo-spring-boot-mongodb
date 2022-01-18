package com.coderhouse.mongodb.service;

import com.coderhouse.mongodb.model.User;
import com.coderhouse.mongodb.repository.UserRepository;
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
    private MongoTemplate template;

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
        var query = new Query();
        query.addCriteria(Criteria.where("age").is(age));
        var update = new Update();
        update.set("phone", user.getPhone());
        template.updateFirst(query, update, User.class);
    }

    @Override
    public List<User> findAllAllByAgeSortedLimit(String country, String orderBy, int limit) {
        var query = new Query();
        query.with(Sort.by(
                orderBy.equalsIgnoreCase("DESC")
                        ? Sort.Order.desc("age")
                        : Sort.Order.asc("age")));
        query.limit(limit);
        query.addCriteria(Criteria.where("country").is(country));

        return template.find(query, User.class);
    }

}