package LeetCode.Easy;

// https://leetcode.com/problems/linked-list-cycle/description/

import LeetCode.Model.ListNode;


public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
