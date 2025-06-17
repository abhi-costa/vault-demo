package com.abhi.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhi.demo.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
}
