package com.learn.sub;

import com.learn.sub.addTwoNum.ListNode;

import java.util.List;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return  null;
    }
    public static void main(String[] args) {
        int[] head = {1,2,3,4,5};
        int n = 2;
        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        ListNode  listNode = removeNthNodeFromEnd.createList(head);
        removeNthNodeFromEnd.print(listNode);

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
