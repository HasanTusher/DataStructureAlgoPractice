package com.learn.sub.disjoint;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DisjointSet {

    int[] rank, parent;
    int n;

    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    private void makeSet() {
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
        }
    }

    public int find(int i){
        //System.out.println(Arrays.toString(parent));
       if(parent[i] == i)
       {
           return i;
       }else
           return  find(parent[i]);

    }

    public void union(int x, int y){

        int xRoot = find(x), yRoot = find(y);

        if (xRoot == yRoot){
            //System.out.println("hi there");
            return;

        }

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        }
        else if (rank[yRoot] < rank[xRoot])
        {
            parent[yRoot] = xRoot;
        }

        else
        {
            parent[yRoot] = xRoot;

            rank[xRoot] = rank[xRoot] + 1;
        }
    }

    void print(){
        System.out.println("rank");
        System.out.println(Arrays.toString(this.rank));

        System.out.println("parent");
        System.out.println(Arrays.toString(this.parent));
    }

    public static void main(String[] args) {
        // Let there be 5 persons with ids as
        // 0, 1, 2, 3 and 4
        int n = 5;
        DisjointSet dus = new DisjointSet(n);

        // 0 is a friend of 2
        dus.union(0, 2);

        // 4 is a friend of 2
        dus.union(4, 2);

        // 3 is a friend of 1
        dus.union(3, 1);

        //dus.print();
        // Check if 4 is a friend of 0
        if (dus.find(4) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (dus.find(1) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }


}
