package com.pbrestapi.demo.service;

import com.pbrestapi.demo.model.Node;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NodeRepository {
    private Map<String, Node> nodeStorage = new HashMap<>();
    private Integer nodeIdCounter = 0;
    private

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
        helperDFS(node, visitedNodes);
    }

    private void helperDFS(Node node, Set<String> visitedNodes) {
        System.out.println(node.getId());
        visitedNodes.add(node.getId());
        for (Node subNode : node.getConnectedNodeIds()) {
            if(!visitedNodes.contains(subNode.getId())) {
                helperDFS(subNode, visitedNodes);
            }
        }
    }

    private static Node makeBSThelper(Integer[] nums, int start, int end) throws Exception {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node rootNode = new Node(nums[mid]);
        rootNode.setLeft(makeBSThelper(nums, start, mid-1));
        rootNode.setRight(makeBSThelper(nums, mid+1, end));

        return rootNode;
    }

    public Node sortedArrayToBST(Integer[] nums) throws Exception {
        return makeBSThelper(nums, 0, nums.length - 1);
    }

    public void inOrderTraversal(Node node) {
        if (node == null)
            return;
        // traverse the left child
        inOrderTraversal(node.getLeft());
        // traverse the root node
        System.out.print(node.getId() + "->");
        // traverse the right child
        inOrderTraversal(node.getRight());
    }
}
