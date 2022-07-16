package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonRepositoryTest {
    PersonRepositoryInMemory test = new PersonRepositoryInMemory();
    Person person;
    @BeforeEach
    void setup(){
        person = new Person();
        person.setName("Priyansh");
        person.setAge(18);
    }

    @Test
    void testAddPerson(){
        Person p = test.add(person);
        Assertions.assertEquals(0, p.getUid());
    }
}