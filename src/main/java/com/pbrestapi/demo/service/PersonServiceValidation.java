package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PersonServiceValidation {
    @Autowired
    Map<String, Validator> validators;

//    List<Validator> validators = new ArrayList<>();
//
//    PersonServiceValidation(){
//        validators.add(new AgeValidator());
//        validators.add(new AliasValidator());
//    }

    public void validatePerson(Person person){
       validators.keySet().forEach(validator -> {validators.get(validator).validate(person);});
    }
}