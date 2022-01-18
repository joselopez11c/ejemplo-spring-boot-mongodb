package com.coderhouse.mongodb.controller;

import com.coderhouse.mongodb.model.User;
import com.coderhouse.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coder-house")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/user/all-users")
    public List<User> findUsers() {
        return service.findAll();
    }

    @GetMapping("/user/")
    public User findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @GetMapping("/user")
    public List<User> findUserByAgeGreater(@RequestParam int age) {
        return service.findByAgeGreaterThan(age);
    }

    @GetMapping("/user/all")
    public List<User> findAllByCountrySortedByAge(@RequestParam String country,
                                                  @RequestParam String orderBy,
                                                  @RequestParam int limit) {
        return service.findAllAllByAgeSortedLimit(country, orderBy, limit);
    }

}
