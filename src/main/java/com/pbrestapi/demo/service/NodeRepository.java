package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Node;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NodeRepository {
    Map<String, Node> nodeStorage = new HashMap<>();
    Integer nodeIdCounter = 0;

    public void storeNode(Node node){
        nodeStorage.put(node.getId(), node);
    }

    public boolean idExists(String id) {
        return !(getNodeById(id) == null);
    }

    public Node getNodeById(String id){
        return nodeStorage.get(id);
    }

    public List<Node> getAllNodes() {
        return nodeStorage.values().stream().toList();
    }

    public String generateNodeId() {
        return (nodeIdCounter++).toString();
    }
}
