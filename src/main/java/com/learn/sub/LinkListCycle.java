package com.learn.sub;

import com.learn.sub.addTwoNum.ListNode;

public class LinkListCycle {
    public boolean hasCycle(ListNode head) {
        if(head.next == null)
            return true;
        ListNode ptr = head;
        ListNode ptr2 = head.next;
        //increase ptr by 1
        while (ptr!=null && ptr2!=null){
            if(ptr!=null){
                ptr = ptr.next;
            }

            if(ptr2 != null){
                ptr2 = ptr2.next == null ? ptr2.next : ptr2.next.next;
            }
            if(ptr == ptr2 && ptr!= null)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] a = {1};
        LinkListCycle linkListCycle = new LinkListCycle();
        ListNode listNode = linkListCycle.createListWithCycle(a, -1);
        System.out.println(linkListCycle.hasCycle(listNode));;
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
