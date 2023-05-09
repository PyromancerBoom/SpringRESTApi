package com.pbrestapi.demo.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class Node {

    private Map<String, Integer> data;
    private String id;
    Set<String> connectedNodeIds = new HashSet<>();

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

    public void addConnectionTo(Node node){
        this.connectedNodeIds.add(node.getId());
    }

    public void twoWayConnectionTo(Node node){
        this.connectedNodeIds.add(node.getId());
        node.addConnectionTo(this);
    }

}
