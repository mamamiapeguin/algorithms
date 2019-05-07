package com.algo;

import edu.princeton.cs.algs4.StdOut;

import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode re = new ListNode(0);
        ListNode cursorRe = re;
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        while (cursor1 != null || cursor2 != null) {
            int sum = (cursor1 == null ? 0 : cursor1.val) + (cursor2 == null ? 0 :cursor2.val) + cursorRe.val;
            cursorRe.val = sum % 10;
            cursorRe.next = new ListNode(sum >= 10 ? 1 : 0);
            if (cursor1 != null) cursor1 = cursor1.next;
            if (cursor2 != null) cursor2 = cursor2.next;
            if (cursor1 == null && cursor2 == null && cursorRe.next.val == 0) {
                cursorRe.next = null;
            }
            cursorRe = cursorRe.next;
        }

        return re;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        ListNode l11 = new ListNode(4);
//        l1.next = l11;
//        ListNode l12 = new ListNode(3);
//        l11.next = l12;

        ListNode l2 = new ListNode(9);
        ListNode l21 = new ListNode(9);
        l2.next = l21;
//        ListNode l22 = new ListNode(4);
//        l21.next = l22;

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode re = solution.addTwoNumbers(l1, l2);
        while (re != null) {
            StdOut.println(re.val);
            re = re.next;
        }
    }
}
