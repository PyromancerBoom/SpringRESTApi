package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Person;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
public class AliasValidator implements Validator {
    @Override
    public void validate(Person person) {
        if (person.getAlias() == null || person.getAlias().isEmpty())
            throw new InvalidParameterException("Alias is empty or null");
    }
}
