package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceMemory implements PersonService {
    List<Person> persons = new ArrayList<>();

    @Override
    public void generateID(Person person){

    }

    @Override
    public void storePerson(Person person){
        persons.add(person);
    }

    @Override
    public Person getPerson(String name) {
        for(Person person:persons){
            if (person.getName().equals(name))
                return person;
        }
        return null;
    }
}