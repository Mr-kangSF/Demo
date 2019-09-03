package com.wankang.demo.service.LeeCode;

/**
 * 两数相加
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author wankang
 * @create 2019-08-28 17:11
 **/
public class LeeCodeTest02 {

    public static void main(String... args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        n1.setNext(n2);
        ListNode n3 = new ListNode(3);
        n2.setNext(n3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        n4.setNext(n5);
        ListNode n6 = new ListNode(4);
        n5.setNext(n6);
        ListNode listNode = addTwoNumbers(n1, n4);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers(ListNode n1, ListNode n2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = n1, q = n2, curr = dummyHead;
        // 进位
        int carry = 0;
        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }


}


class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}