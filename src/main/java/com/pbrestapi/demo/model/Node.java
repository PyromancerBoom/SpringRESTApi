package com.pbrestapi.demo.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class Node {

    private Integer data;
    private String id;
    private Set<Node> connectedNodeIds = new HashSet<>();

    public Node(Integer data) throws Exception {
        if(data == null ){
            throw new Exception("Node must have data!");
        }
        this.data = data;
    }

    public Node(Integer data, String id) throws Exception {
        if(data == null ){
            throw new Exception("Node must have data!");
        }
        this.data = data;
        this.id = id;
    }

    public Set<Node> getConnectedNodeIds() {
        return connectedNodeIds;
    }

    public void addConnectionTo(Node node){
        this.connectedNodeIds.add(node);
    }

    public void twoWayConnectionTo(Node node){
        this.connectedNodeIds.add(node);
        node.addConnectionTo(this);
    }


}
