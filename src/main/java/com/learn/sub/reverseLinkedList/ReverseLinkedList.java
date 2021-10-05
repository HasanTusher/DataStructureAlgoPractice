package com.learn.sub.reverseLinkedList;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        return null;
    }
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        int[] a = {1,2,3,4,5};
        ListNode listNode = reverseLinkedList.createList(a);
        reverseLinkedList.print(listNode);

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
