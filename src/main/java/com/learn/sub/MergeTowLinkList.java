package com.learn.sub;

import com.learn.sub.addTwoNum.ListNode;
import com.learn.sub.reverseLinkedList.ReverseLinkedList;

import java.util.List;

public class MergeTowLinkList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode left = l1;
        ListNode right = l2;

        ListNode lastLeft = new ListNode();
        ListNode lastRight = new ListNode();

        ListNode newHead = left.val < right.val ? left : right;

        while (left !=null && right !=null){
            if(left.val < right.val){
                lastLeft = left;
                ListNode temp = left.next;
                left.next = right;
                left = temp;
            }else {
                lastRight = right;
                ListNode temp = right.next;
                right.next = left;
                right = temp;
            }
        }

        if (left!=null){
            lastRight.next = left;
        }

        if (right!=null){
            lastLeft.next = right;
        }

        this.print(newHead);
        return newHead;
    }

    public static void main(String[] args) {
        MergeTowLinkList reverseLinkedList = new MergeTowLinkList();
        int[] a = {1,2, 4};
        int[] b = {1,3,4};
        ListNode listNode = reverseLinkedList.createList(a);
        ListNode listNode2 = reverseLinkedList.createList(b);
        reverseLinkedList.mergeTwoLists(listNode, listNode2);
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
