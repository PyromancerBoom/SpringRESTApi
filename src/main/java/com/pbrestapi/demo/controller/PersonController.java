package com.pbrestapi.demo.controller;

import com.pbrestapi.demo.model.Hello;
import com.pbrestapi.demo.model.Person;
import com.pbrestapi.demo.service.PersonService;
import com.pbrestapi.demo.service.PersonServiceMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/hi", method = GET)
    public Hello test(){
        return new Hello(101, "Hello World");
    }

    @RequestMapping(value = "/", method = GET)
    public Hello defaultRoute(){
        return new Hello(101, "Default ");
    }

    @RequestMapping(value = "/person", method = POST)
    public Person createPerson(@RequestBody Person person){
        //TODO: Validate person.
        personService.storePerson(person);
        return person;
    }

    @RequestMapping(value = "/person/name", method = GET)
    public ResponseEntity<Person> showPerson(@RequestParam String name){
        return new ResponseEntity<Person>(personService.getPersonByName(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/person/{id}", method = GET)
    public ResponseEntity<Person> showPersonbyid(@PathVariable Integer id){
//        return personService.getPersonByID(id);
        return new ResponseEntity<Person>(personService.getPersonByID(id), HttpStatus.OK);
    }
}