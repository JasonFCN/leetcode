package com.cwj.leetcode;

public class GetDecimalValue1290 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        node1.next = node2;
        head.next = node1;
        System.out.println(getDecimalValue(head));
    }

    public static int getDecimalValue(ListNode head) {
        int n = 0;
        do{
            n = (n << 1) + head.val;
            head = head.next;
        }while(head!=null);
        return n;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}