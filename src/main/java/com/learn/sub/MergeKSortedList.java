package com.learn.sub;

import com.learn.sub.addTwoNum.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        ArrayList<ListNode> listNodes = new ArrayList<>();
        //Collections.addAll(listNodes, lists);
        //Collections.sort(listNodes);
        for (int i = 0; i < lists.length; i++) {
            ListNode listNode = lists[i];
            while (listNode!=null){
                listNodes.add(listNode);
                listNode = listNode.next;
            }
        }

        Collections.sort(listNodes, Comparator.comparing(a->a.val));
        for (int i = 0; i < listNodes.size()-1; i++) {
            listNodes.get(i).next = listNodes.get(i+1);
        }
        if(!listNodes.isEmpty())
            listNodes.get(listNodes.size()-1).next = null;
        else
            return null;
        //this.print(listNodes.get(0));
        return listNodes.get(0);
    }


    public static void main(String[] args) {
        MergeKSortedList mergeTowLinkList = new MergeKSortedList();

//        int lists[][] = {{1,4,5},{1,3,4},{2,6}};
        int lists[][] = {{}};
        ListNode[] listNodes = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            listNodes[i] = mergeTowLinkList.createList(lists[i]);
        }
        mergeTowLinkList.mergeKLists(listNodes);
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
