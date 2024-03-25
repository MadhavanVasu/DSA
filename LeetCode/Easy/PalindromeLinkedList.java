package LeetCode.Easy;

import LeetCode.Model.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindromeOptimal(ListNode head) {
        if (head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode reverseHead = null;
        while (fast != null && fast.next != null) {
            ListNode temp = slow.next;
            slow.next = reverseHead;
            reverseHead = slow;
            slow = temp;
            fast = fast.next.next;
        }
        // If odd number of nodes in Linked List
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (slow.val != reverseHead.val) return false;
            slow = slow.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    public ListNode reverseLinkedList(ListNode nextHead, ListNode currHead) {
        if (nextHead == null) return currHead;
        ListNode temp = nextHead.next;
        nextHead.next = currHead;
        currHead = nextHead;
        nextHead = temp;
        return reverseLinkedList(nextHead, currHead);
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = head;
        int i = 0;
        while (i != n / 2) {
            secondHalf = secondHalf.next;
            i++;
        }
        if (n % 2 != 0) secondHalf = secondHalf.next;
        secondHalf = reverseLinkedList(secondHalf, null);
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
