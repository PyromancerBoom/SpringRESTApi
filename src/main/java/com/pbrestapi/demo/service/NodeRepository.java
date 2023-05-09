package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Node;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NodeRepository {
    List<Node> nodeStorage = new ArrayList<>();
    Integer nodeIdCounter = 0;

    public void storeNode(Node node){
        nodeStorage.add(node);
    }

    public boolean idExists(String id) {
        return !(getNodeById(id) == null);
    }

    public Node getNodeById(String id){
        for (Node node: nodeStorage) {
            if(node.getId().equals(id)){
                return node;
            }
        }
        return null;
    }

    public List<Node> getAllNodes() {
        return nodeStorage;
    }

    public String generateNodeId() {
        return (nodeIdCounter++).toString();
    }
}
