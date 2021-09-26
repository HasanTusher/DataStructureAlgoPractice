package com.learn.sub.graphClone;

import java.util.Arrays;
import java.util.List;

public class GraphClone {

    public Node cloneGraph(Node node) {


        return node;
    }
    public static void main(String[] args) {
        int arr[][] = {{2,4},{1,3},{2,4},{1,3}};
        GraphClone graphClone  = new GraphClone();
        Node aa = graphClone.createGraphFromArrays(arr);
        graphClone.cloneGraph(aa);
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
