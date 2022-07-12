package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;

public interface PersonService {

    void storePerson(Person person);

    Person getPerson(String name);

    Person getPersonByID(Integer id);
}
