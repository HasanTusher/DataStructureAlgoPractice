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

    private List<Integer> getTraversalVals(Node current, Queue<Node> graph) {
        List<Node> nodes = current.neighbors;
        List<Integer> integers = new ArrayList<>();
        for (Node node:
             nodes) {
                graph.add(node);
                integers.add(node.val);

        }
        return integers;

    }

    private Node traverseAndClone(Node node){
        if(node ==null){
            return null;
        }
        if(node.neighbors.isEmpty()){
            return new Node(1);
        }
        //traverse
        Queue<Node> graph = new LinkedList<>();

        Node head = node;
        HashSet<Node> alreadyTraversed = new HashSet<>();
        graph.add(head);
        HashMap<Integer, List<Integer>> lists = new HashMap<>();
        while (!graph.isEmpty()){
            Node current = graph.poll();
            if(!alreadyTraversed.contains(current)){
                List<Integer> connectedVals = this.getTraversalVals(current, graph);
                lists.put(current.val, connectedVals);
                alreadyTraversed.add(current);
            }

        }

        return this.createGraphFromArrays3(lists, alreadyTraversed);

    }

    private Node createGraphFromArrays3(HashMap<Integer, List<Integer>> lists, HashSet<Node> alreadyTraversed) {
        int size = alreadyTraversed.size();
        Node[] listOfNodes = new Node[size];
        for (int i = 0; i < size; i++) {
            listOfNodes[i] = new Node(i+1);
        }

        Iterator iterator = lists.entrySet().iterator();
        for (Map.Entry mapElement : lists.entrySet()) {
            Integer key = (Integer)mapElement.getKey();
            List<Integer> integers = lists.get(key);
            for (Integer integer:
                 integers) {
                listOfNodes[key-1].neighbors.add(listOfNodes[integer-1]);
            }

        }
        return listOfNodes[0];
    }


    public Node cloneGraph(Node node) {
        return this.traverseAndClone(node);
    }
    public static void main(String[] args) {
//        int arr[][] = {{2,4},{1,3},{2,4},{1,3}};
        int arr[][] = {{2},{1}};
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
