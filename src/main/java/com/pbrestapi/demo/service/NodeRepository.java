package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Node;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NodeRepository {
    Map<String, Node> nodeStorage = new HashMap<>();
    Integer nodeIdCounter = 0;

    public NodeRepository() throws Exception {
        Node node0 = new Node(1, "0");
        Node node1 = new Node(454, "1");
        Node node2 = new Node(-78678, "2");
        Node node3 = new Node(153, "3");
        Node node4 = new Node(-7689, "4");
        Node node5 = new Node(488, "5");

        node1.addConnectionTo(node2);
        node1.addConnectionTo(node5);
        node2.addConnectionTo(node3);
        node3.addConnectionTo(node4);
        node5.addConnectionTo(node2);
        node5.addConnectionTo(node3);
        node5.addConnectionTo(node4);

        nodeStorage.put("0", node0 );
        nodeStorage.put("1",node1);
        nodeStorage.put("2",node2);
        nodeStorage.put("3",node3);
        nodeStorage.put("4",node4);
        nodeStorage.put("5",node5);
    }


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

    public void dfs(Node node){
        Set<String> visitedNodes = new HashSet<>();
        helper(node, visitedNodes);
    }

    private void helper(Node node, Set<String> visitedNodes) {
        System.out.println(node.getId());
        visitedNodes.add(node.getId());
        for (Node subNode : node.getConnectedNodeIds()) {
            if(!visitedNodes.contains(subNode.getId())) {
                helper(subNode, visitedNodes);
            }
        }
    }
}
