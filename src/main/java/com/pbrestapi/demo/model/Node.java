package com.pbrestapi.demo.model;

import lombok.Data;
import java.util.Map;

@Data
public class Node {

    private Map<String, Integer> data;
    private String id;

    public Node(Map<String, Integer> data) throws Exception {
        if(data == null || data.isEmpty()){
            throw new Exception("Node must have data!");
        }
        this.data = data;
    }

    public Node(Map<String, Integer> data, String id) throws Exception {
        if(data == null || data.isEmpty()){
            throw new Exception("Node must have data!");
        }
        this.data = data;
        this.id = id;
    }

}
