package com.learn.sub.addTwoNum;


public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void printList(){
        ListNode ptr = this;
        while (ptr !=null){
            System.out.println(ptr.val +" ");
            ptr = ptr.next;
        }
        System.out.print("\n");
    }
}


