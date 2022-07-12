package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonServiceMemory implements PersonService {
    List<Person> persons = new ArrayList<>();
    Integer id = 0;

    private void generateID(Person person){
        this.id++;
        person.setUid(this.id);
    }

    @Override
    public void storePerson(Person person){
        generateID(person);
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
    @Override
    public Person getPersonByID(Integer id) {
        for(Person person:persons){
            if (Objects.equals(person.getUid(), id))
                return person;
        }
        return null;
    }

}