package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class DoubleANumberRepresentedAsLL {

    public ListNode reverseLL(ListNode newHead, ListNode currHead) {
        if (newHead == null) return currHead;
        ListNode next = newHead.next;
        newHead.next = currHead;
        return reverseLL(next, newHead);
    }

    public ListNode doubleIt(ListNode head) {
        head = reverseLL(head, null);
        int carry = 0;
        ListNode result = null;
        while (head != null) {
            int val = head.val * 2 + carry;
            if (val >= 10) {
                val = val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(val);
            node.next = result;
            result = node;
            head = head.next;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = result;
            result = node;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
