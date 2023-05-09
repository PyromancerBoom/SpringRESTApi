package com.pbrestapi.demo.controller;

import com.pbrestapi.demo.model.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class Htmltest {
    @RequestMapping(value = "/index", method = GET)
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");
        return modelAndView;
    }

    @RequestMapping(value = "/index2", method = GET)
    public String test2(){

        return "<H1> MYY PAGE!!! </H1><BR><p>Chichu <span style=\"color:red\">mon</span></p>";

    }
}
