package com.pbrestapi.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.minidev.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Data
public class Person {
    @JsonProperty("age") Integer age;
    @JsonProperty("name") String name;
    @JsonProperty("alias") String alias;
}