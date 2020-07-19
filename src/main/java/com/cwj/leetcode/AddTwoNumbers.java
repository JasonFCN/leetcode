package com.cwj.leetcode;


public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1a = new ListNode(2);
        ListNode node2a = new ListNode(4);
        ListNode node3a = new ListNode(3);
        node1a.next = node2a;
        node2a.next = node3a;

        ListNode node1b = new ListNode(5);
        ListNode node2b = new ListNode(6);
        ListNode node3b = new ListNode(4);
        node1b.next = node2b;
        node2b.next = node3b;

        ListNode node = addTwoNumbers2(node1a, node1b);
        print(node);
    }
    public static void print(ListNode node){
        if(node!=null){
            System.out.println(node.val);
            print(node.next);
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 结果
        ListNode result = new ListNode(0);

        // 当前进行运算的节点
        ListNode n1 = l1, n2 = l2, current = result;
        // 进位
        int carry = 0;

        // 当存在下一个节点时：
        while(n1 != null || n2 != null){
            // 1,计算余数和进位
            int a = n1==null ? 0 : n1.val;
            int b = n2==null ? 0 : n2.val;
            // carry等于（当前两个节点值之和+ 上次的进位）/10
            carry = (current.val + a + b) / 10;
            // 余数
            int val = (current.val + a + b) % 10;
            // 设置该节点的值
            current.val = val;


            // 2, 设置下次要参与计算的节点
            if(n1!=null){
                n1 = n1.next;
            }
            if(n2!=null){
                n2 = n2.next;
            }
            // 如果还有节点未参与计算或最后的计算有进位，则创建高位节点
            if(n1 != null || n2 != null|| carry>0){
                current.next = new ListNode(carry);
            }
            current = current.next;
        }
        return result;
    }

    // 位运算
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode valResult = new ListNode(0);
        ListNode carryResult = new ListNode(0);
        // 当前进行运算的节点
        ListNode n1 = l1, n2 = l2, current1 = valResult, current2 = carryResult;
        boolean haveCarry = false;
        while(n1 != null || n2 != null){
            // 1,计算余数和进位
            int a = n1==null ? 0 : n1.val;
            int b = n2==null ? 0 : n2.val;

            // 余数
            int val = (a + b) % 10;
            // 进位
            int carry = (a + b) / 10;
            if(carry>0){
                haveCarry = true;
            }
            current1.val = val;
            current2.val = carry;

            if(n1!=null){
                n1 = n1.next;
            }
            if(n2!=null){
                n2 = n2.next;
            }
            if(n1 != null || n2 != null){
                current1.next = new ListNode(0);
                current2.next = new ListNode(0);
            }else{
                // 右移，左边补一个节点
                ListNode n = new ListNode(0);
                n.next = carryResult;
                carryResult = n;
                if(carry>0){
                    current1.next = new ListNode(0);
                }else{
                    ListNode next = carryResult;
                    while(next!=null){
                        if(next.next!=null&&next.next.next==null){
                            next.next = null;
                        }
                        next = next.next;
                    }
                }
                break;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        if(haveCarry){
            return addTwoNumbers2(valResult, carryResult);
        }
        return valResult;
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}