package com.pbrestapi.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Person {
    @JsonProperty("id") Integer uid;
    @JsonProperty("age") Integer age;
    @JsonProperty("name") String name;
    @JsonProperty("alias") String alias;
}