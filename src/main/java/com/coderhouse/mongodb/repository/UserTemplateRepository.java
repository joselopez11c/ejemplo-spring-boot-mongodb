package com.coderhouse.mongodb.repository;

import com.coderhouse.mongodb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserTemplateRepository  {

    List<User> findAllAllByAgeSortedLimit(String country, String orderBy, int limit);
}
