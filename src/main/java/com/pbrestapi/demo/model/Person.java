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

    @JsonIgnore String path = "file.txt";
    File file = new File(path);

    public void createFile(){
        try {

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addPersontoFile(){
        JSONObject json = new JSONObject();
        try {
            json.put(name, age);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(path), true)) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}