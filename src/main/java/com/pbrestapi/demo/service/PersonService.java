package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;

public interface PersonService {

    Person storePerson(Person person);

    Person getPersonByName(String name);

    Person getPersonByID(Integer id);
}
