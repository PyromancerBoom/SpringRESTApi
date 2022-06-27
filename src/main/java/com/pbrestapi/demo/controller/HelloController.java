package com.pbrestapi.demo.controller;

import com.pbrestapi.demo.model.Hello;
import com.pbrestapi.demo.model.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class HelloController {

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
        return person;
    }
}