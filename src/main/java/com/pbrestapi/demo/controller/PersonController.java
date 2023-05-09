package com.pbrestapi.demo.controller;

import com.pbrestapi.demo.model.Hello;
import com.pbrestapi.demo.model.Node;
import com.pbrestapi.demo.model.Person;
import com.pbrestapi.demo.service.NodeRepository;
import com.pbrestapi.demo.service.PersonService;
import com.pbrestapi.demo.service.PersonServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    PersonServiceValidation personServiceValidation;

    @Autowired
    NodeRepository nodeRepository;

    @RequestMapping(value = "/hi", method = GET)
    public Hello test(){
        return new Hello(101, "Hello World");
    }

    @RequestMapping(value = "/", method = GET)
    public Hello defaultRoute(){
        return new Hello(101, "Default ");
    }

    @RequestMapping(value = "/person", method = POST)
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        try{
            personServiceValidation.validatePerson(person);
            return new ResponseEntity<Person>(personService.storePerson(person), HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<Person>((Person) null, HttpStatus.BAD_REQUEST);
        }
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

    @RequestMapping(value = "/node", method = POST)
    public ResponseEntity<?> addNode(@RequestBody Map<String, Integer> data){
        try{
            Node node = new Node(data, nodeRepository.generateNodeId());
            nodeRepository.storeNode(node);
            return new ResponseEntity<>(node, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/node/{id}", method = POST)
    public ResponseEntity<?> addNode(@RequestBody Map<String, Integer> data, @PathVariable String id){
        try{
            Node node;
            if(nodeRepository.idExists(id)){
                node = nodeRepository.getNodeById(id);
                node.getData().clear();
                node.getData().putAll(data);
            } else {
                node = new Node(data, id);
                nodeRepository.storeNode(node);
            }
            return new ResponseEntity<>(node, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/node/all", method = GET)
    public ResponseEntity<?> getAllNodes() {
        return new ResponseEntity<>(nodeRepository.getAllNodes(), HttpStatus.OK);
    }

    @RequestMapping(value = "/node/connection", method = POST)
    public ResponseEntity<?> createConnections(@RequestBody Map<String, String> nodeMapping) {
        nodeMapping.keySet().forEach(key -> {
            nodeRepository.getNodeById(key).addConnectionTo(nodeRepository.getNodeById(nodeMapping.get(key)));
        });
        return new ResponseEntity<>(nodeRepository.getAllNodes(), HttpStatus.OK);
    }
}