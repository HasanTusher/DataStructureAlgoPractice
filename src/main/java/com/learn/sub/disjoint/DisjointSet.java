package com.learn.sub.disjoint;

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
        // If i is the parent of itself
        if (parent[i] == i)
        {
            // Then i is the representative of
            // this set
            return i;
        }
        else
        {
            // Else if i is not the parent of
            // itself, then i is not the
            // representative of his set. So we
            // recursively call Find on its parent
            return this.find(parent[i]);
        }

    }

    public void union(int x, int y){

        // Find representatives of two sets
        int xRoot = find(x), yRoot = find(y);


        // Elements are in the same set, no need
        // to unite anything.
        if (xRoot == yRoot){
            System.out.println("hi there");
            return;

        }

        // If x's rank is less than y's rank
        if (rank[xRoot] < rank[yRoot]) {
            System.out.println("yaya");
            // Then move x under y  so that depth
            // of tree remains less
            parent[xRoot] = yRoot;
        }
            // Else if y's rank is less than x's rank
        else if (rank[yRoot] < rank[xRoot])
        {   // Then move y under x so that depth of
            // tree remains less
            System.out.println("nay");
            parent[yRoot] = xRoot;
        }

        else // if ranks are the same
        {
            // Then move y under x (doesn't matter
            // which one goes where)
            System.out.println("damn");
            parent[yRoot] = xRoot;

            // And increment the result tree's
            // rank by 1
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
        DisjointSet dus =
                new DisjointSet(n);

        // 0 is a friend of 2
        dus.union(0, 2);

        // 4 is a friend of 2
        dus.union(4, 2);

        // 3 is a friend of 1
        dus.union(3, 1);

        dus.print();
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
