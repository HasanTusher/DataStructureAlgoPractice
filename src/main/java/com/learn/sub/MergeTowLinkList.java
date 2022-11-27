package com.learn.sub;

import com.learn.sub.addTwoNum.ListNode;
import com.learn.sub.reverseLinkedList.ReverseLinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MergeTowLinkList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode left = l1;
        ListNode right = l2;


        //ListNode lastLeft = new ListNode();
        //ListNode lastRight = new ListNode();

        //ListNode newHead = left.val < right.val ? left : right;
        Queue<ListNode> listNodes = new LinkedList<>();
        while (left !=null && right !=null){
            if(left.val < right.val){
                listNodes.add(left);
                left = left.next;
            }else{
                listNodes.add(right);
                right= right.next;
            }
        }

        while (left!=null){
            listNodes.add(left);
            left = left.next;
        }

        while (right!=null){
            listNodes.add(right);
            right = right.next;
        }

        ListNode newHead = listNodes.poll();
        ListNode curr = newHead;
        curr.next = null;
        while (!listNodes.isEmpty()){
            ListNode temp = listNodes.poll();
            temp.next = null;
            curr.next  = temp;
            curr = temp;
        }
        this.print(newHead);
        return newHead;
    }

    public static void main(String[] args) {
        MergeTowLinkList reverseLinkedList = new MergeTowLinkList();
        int[] a = {-9,3};
        int[] b = {5,7};
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
