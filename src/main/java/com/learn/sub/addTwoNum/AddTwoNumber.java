package com.learn.sub.addTwoNum;

import java.math.BigInteger;
import java.util.Deque;
import java.util.LinkedList;

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

        StringBuilder stringBuilder = new StringBuilder();
        BigInteger firstNumber;
        while (sizeOfFirst > 0){
            stringBuilder.append(deque.pollFirst());
            sizeOfFirst--;
        }

        firstNumber = new BigInteger(stringBuilder.toString());
        //clear for new one
        stringBuilder.setLength(0);

        BigInteger secondNumber;
        while (sizeOfLast > 0){
            stringBuilder.append(deque.pollLast());
            sizeOfLast--;
        }
        secondNumber = new BigInteger(stringBuilder.toString());

        BigInteger result = firstNumber.add(secondNumber);
        stringBuilder.setLength(0);
        String s = stringBuilder.append(result).reverse().toString();
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < s.length(); i++) {
            if(i==0){
                head = new ListNode(Character.getNumericValue(s.charAt(i)), null);
                tail = head;
            }else{
                ListNode temp = new ListNode(Character.getNumericValue(s.charAt(i)), null);
                tail.next = temp;
                tail = temp;
            }
        }
        head.printList();
        return head;

    }


    public static void main(String[] args) {
//        int arr[] = {2,4,3};
//        int arr2[] = {5,6,4};
//        int arr[] = {9};
//        int arr2[] = {1,9,9,9,9,9,9,9,9,9};

        int arr[] = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        int arr2[] ={5,6,4};

        ListNode listNode1 = createListNode(arr);
        ListNode listNode2 = createListNode(arr2);

        //listNode1.printList();
        //listNode2.printList();

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
