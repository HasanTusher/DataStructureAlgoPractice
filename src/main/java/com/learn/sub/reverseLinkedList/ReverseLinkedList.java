package com.learn.sub.reverseLinkedList;

import com.learn.sub.addTwoNum.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode ptr = head;
        ListNode previous = null;


        while (ptr != null){
          ListNode next = ptr.next;
          ptr.next = previous;
          previous = ptr;
          ptr = next;
        }

        //System.out.println(previous.val);
        //this.print(previous);
        return previous;

    }
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        int[] a = {1,2};
        ListNode listNode = reverseLinkedList.createList(a);
        reverseLinkedList.reverseList(listNode);
        //reverseLinkedList.print(listNode);

    }

    private ListNode createList(int a[]){
        ListNode head;
        ListNode temp;
        head = new ListNode(a[0], null);
        temp = head;
        for (int i = 1; i < a.length; i++) {
            temp.next = new ListNode(a[i], null);
            temp = temp.next;
        }
        return head;
    }

    private void print(ListNode head){
        ListNode temp = head;
        while (temp!=null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
