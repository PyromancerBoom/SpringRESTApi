package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;

@Service
public class AgeValidator implements Validator {
    @Override
    public void validate(Person person) {
        if(person.getAge() <= 0)
            throw new InvalidParameterException("Age invalid!");
        else if (person.getAge() == null)
            throw new InvalidParameterException("Age cannot be null");
    }
}
