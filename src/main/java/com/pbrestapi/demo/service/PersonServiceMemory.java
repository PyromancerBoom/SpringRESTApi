package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceMemory implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public void storePerson(Person person){
        personRepository.add(person);
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