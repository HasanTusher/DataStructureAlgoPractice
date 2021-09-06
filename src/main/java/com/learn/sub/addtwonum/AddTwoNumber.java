package com.learn.sub.addtwonum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Deque<Integer> deque = new LinkedList<>();

        ListNode ptr = l1;
        int sizeOfFirst = 0;
        int sizeOfLast = 0;
        while (ptr !=null){
            deque.addFirst(ptr.val);
            sizeOfFirst++;
            ptr = ptr.next;
        }

        ptr = l2;
        while (ptr !=null){
            deque.addLast(ptr.val);
            sizeOfLast++;
            ptr = ptr.next;

        }



        return new ListNode();

    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int arr2[] = {9,8,7,6};

        ListNode listNode1 = createListNode(arr);
        ListNode listNode2 = createListNode(arr2);

        listNode1.printList();
        listNode2.printList();

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        addTwoNumber.addTwoNumbers(listNode1, listNode2);
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
