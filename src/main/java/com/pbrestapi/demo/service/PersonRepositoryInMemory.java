package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonRepositoryInMemory implements PersonRepository{
    private final List<Person> persons = new ArrayList<>();
    private Integer id = 0;

    private Integer generateID(Person person){
        return this.id++;
    }

    public Person add(Person person){
        id = generateID(person);
        person.setUid(this.id);
        persons.add(person);
        return person;
    }

    public Person getByName(String name) {
        for(Person person:persons){
            if (person.getName().equals(name))
                return person;
        }
        return null;
    }

    public Person getById(Integer id) {
        if (id > persons.size())
            return null;
        return persons.get(id-1);
    }
}