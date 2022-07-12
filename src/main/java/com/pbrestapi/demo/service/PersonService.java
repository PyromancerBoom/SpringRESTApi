package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;

public interface PersonService {
    void generateID(Person person);

    void storePerson(Person person);

    Person getPerson(String name);
}
