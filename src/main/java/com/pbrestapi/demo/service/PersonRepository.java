package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;

public interface PersonRepository {
    void add(Person person);
    public Person getByName(String name);
    public Person getById(Integer id);
}
