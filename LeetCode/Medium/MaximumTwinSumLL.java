package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class MaximumTwinSumLL {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }

    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = reverseList(slow);
        int max = 0;
        while (secondHalf != null) {
            int sum = head.val + secondHalf.val;
            max = Math.max(sum, max);
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
