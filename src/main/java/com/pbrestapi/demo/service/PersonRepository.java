package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;

public interface PersonRepository {
    Person add(Person person);
    Person getByName(String name);
    Person getById(Integer id);
}
