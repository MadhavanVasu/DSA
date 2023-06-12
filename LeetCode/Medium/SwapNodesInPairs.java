package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;
        while (head.next != null && head.next.next != null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = head.next.next;
            head.next.next = temp;
            head = temp;
        }
        return newHead.next;
    }

    public static void main(String[] args) {

    }

}
