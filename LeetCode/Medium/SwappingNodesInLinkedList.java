package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class SwappingNodesInLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) fast = fast.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode start = head;
        for (int i = 1; i < k; i++) start = start.next;
        int temp = start.val;
        start.val = slow.val;
        slow.val = temp;
        return head;
    }

    public static void main(String[] args) {

    }

}
