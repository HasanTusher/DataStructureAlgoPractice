package com.learn.sub.graphClone;

import java.util.*;

public class GraphClone {

    private Node createGraphFromArrays2(List<List<Integer>> arr) {
        if(arr.size() == 0)
            return new Node(1);

        Node[] listOfNodes = new Node[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            listOfNodes[i] = new Node(i+1);
        }

        for(int i = 0; i< arr.size(); i++){
            int temp = i+1; // val of the node
            for (int j = 0; j < arr.get(i).size(); j++) {
                listOfNodes[i].neighbors.add(listOfNodes[arr.get(i).get(j)-1]);
            }
        }
        return listOfNodes[0];
    }

    private List<Integer> getTraversalVals(Node current, HashSet<Node> alreadyTraversed, Queue<Node> graph) {
        List<Node> nodes = current.neighbors;
        List<Integer> integers = new ArrayList<>();
        for (Node node:
             nodes) {
            //if(!alreadyTraversed.contains(node)){
                graph.add(node);
                integers.add(node.val);
//            }

        }
        return integers;

    }

    private Node traverseAndClone(Node node){
        //traverse
        Queue<Node> graph = new LinkedList<>();

        Node head = node;
        HashSet<Node> alreadyTraversed = new HashSet<>();
        graph.add(head);
        List<List<Integer>> lists = new ArrayList<>();
        while (!graph.isEmpty()){
            Node current = graph.poll();
            if(!alreadyTraversed.contains(current)){
                List<Integer> connectedVals = this.getTraversalVals(current, alreadyTraversed, graph);
                lists.add(connectedVals);
                alreadyTraversed.add(current);
            }

        }

        return this.createGraphFromArrays2(lists);

    }



    public Node cloneGraph(Node node) {
        return this.traverseAndClone(node);
    }
    public static void main(String[] args) {
        int arr[][] = {{2,4},{1,3},{2,4},{1,3}};
        GraphClone graphClone  = new GraphClone();
        Node aa = graphClone.createGraphFromArrays(arr);
        Node x = graphClone.cloneGraph(aa);
        System.out.println(x);
    }



    private Node createGraphFromArrays(int[][] arr) {
        if(arr[0].length == 0)
            return new Node(1);

        Node[] listOfNodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            listOfNodes[i] = new Node(i+1);
        }

        for(int i = 0; i< arr.length; i++){
            int temp = i+1; // val of the node
            for (int j = 0; j < arr[i].length; j++) {
                listOfNodes[i].neighbors.add(listOfNodes[arr[i][j]-1]);
            }
        }
        return listOfNodes[0];
    }
}
