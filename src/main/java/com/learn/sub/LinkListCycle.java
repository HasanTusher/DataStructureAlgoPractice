package com.learn.sub;

import com.learn.sub.addTwoNum.ListNode;

public class LinkListCycle {
    public boolean hasCycle(ListNode head) {



        return true;
    }


    public static void main(String[] args) {
        int[] a = {3,2,0,-4};
        LinkListCycle linkListCycle = new LinkListCycle();
        ListNode listNode = linkListCycle.createListWithCycle(a, 0);
        linkListCycle.print(listNode);
    }

    private ListNode createListWithCycle(int[] a, int k) {
            ListNode head;
            ListNode temp;
            ListNode dest = new ListNode();
            head = new ListNode(a[0], null);
            temp = head;
            for (int i = 1; i < a.length; i++) {
                temp.next = new ListNode(a[i], null);
                temp = temp.next;
                if(i==k){
                    dest = temp;
                }
            }
            if(k ==0){
                temp.next = head;
            }
            if(k>0 && k<a.length){
                temp.next = dest;
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
