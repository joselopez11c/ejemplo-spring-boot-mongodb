package com.coderhouse.mongodb.repository;

import com.coderhouse.mongodb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserTemplateRepositoryImpl implements UserTemplateRepository {

    @Autowired
    MongoTemplate template;

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
