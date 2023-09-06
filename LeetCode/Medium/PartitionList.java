package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode nextSmaller = null;
        ListNode nextGreater = null;
        ListNode smaller = null;
        ListNode greater = null;
        while (head != null) {
            if (head.val < x) {
                if (nextSmaller == null) {
                    nextSmaller = head;
                    smaller = nextSmaller;
                } else {
                    nextSmaller.next = head;
                    nextSmaller = nextSmaller.next;
                }
            } else {
                if (nextGreater == null) {
                    nextGreater = head;
                    greater = nextGreater;
                } else {
                    nextGreater.next = head;
                    nextGreater = nextGreater.next;
                }
            }
            head = head.next;
        }
        if (smaller == null) {
            nextGreater.next = null;
            return greater;
        }
        if (greater != null) nextGreater.next = null;
        nextSmaller.next = greater;
        return smaller;
    }

    public static void main(String[] args) {

    }

}
