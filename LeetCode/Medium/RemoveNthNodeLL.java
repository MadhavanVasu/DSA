package Medium;

import LeetCode.Model.ListNode;

public class RemoveNthNodeLL {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode slow = null;
        ListNode fast = head;
        int i = 0;
        while (fast != null) {
            if (i > n) {
                slow = slow.next;
            } else if (i == n)
                slow = head;
            fast = fast.next;
            i++;
        }
        if (slow == null)
            return head.next;
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode temp = head1;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode newList = removeNthFromEnd(head1, 5);
        while (newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }
}
