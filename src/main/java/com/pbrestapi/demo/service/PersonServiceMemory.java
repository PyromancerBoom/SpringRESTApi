package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceMemory implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person storePerson(Person person){
        // return personRepository.add(person);
        return null;
    }

    @Override
    public Person getPersonByName(String name) {
        return personRepository.getByName(name);
    }

    @Override
    public Person getPersonByID(Integer id) {
        return personRepository.getById(id);
    }

}