package com.learn.sub;

import com.learn.sub.addTwoNum.ListNode;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode ptr = head;
        ListNode secondPtr = head;
        //set second pointer in the correct position
        for (int i = 0; i < n; i++) {
            if(secondPtr.next != null)
                secondPtr = secondPtr.next;
            else
                break;
        }

        if(secondPtr.next == null) // we have to remove the head
        {
            head = head.next;
            this.print(head);
            return head;
        }

        //still more traversing to do
        while (secondPtr.next!=null){
            secondPtr = secondPtr.next;
            ptr = ptr.next;
        }

        ptr.next = ptr.next.next;
        this.print(head);
        return head;
    }
    public static void main(String[] args) {
        int[] head = {1,2};
        int n = 2;
        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        ListNode  listNode = removeNthNodeFromEnd.createList(head);
        removeNthNodeFromEnd.removeNthFromEnd(listNode, 1);
        //removeNthNodeFromEnd.print(listNode);

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
