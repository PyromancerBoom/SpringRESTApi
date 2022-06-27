package com.pbrestapi.demo.controller;

import com.pbrestapi.demo.model.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class HelloController {

    @RequestMapping(value = "/hi", method = GET)
    public Hello test(){
        return new Hello(101, "Hello World");
    }
}