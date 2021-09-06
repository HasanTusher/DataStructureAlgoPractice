package com.learn.sub.addtwonum;

import java.util.List;

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return new ListNode();

    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int arr2[] = {9,8,7,6};

        ListNode listNode1 = createListNode(arr);
        ListNode listNode2 = createListNode(arr2);

        listNode1.printList();
        listNode2.printList();
    }

    private static ListNode createListNode(int[] arr) {
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                head = new ListNode(arr[i], null);
                tail = head;
            }else{
                ListNode temp = new ListNode(arr[i], null);
                tail.next = temp;
                tail = temp;
            }
        }
        return head;
    }
}
