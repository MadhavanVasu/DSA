package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class ReverseLinkedList2 {

    public ListNode optimalReverseBetween(ListNode head, int left, int right) {

        if (left == right) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++)
            prev = prev.next;
        ListNode currHead = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = currHead.next;
            currHead.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        return dummy.next;

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode temp = head;
        ListNode currHead = null;
        ListNode end = null;
        ListNode prev = null;
        int i = 1;
        while (i <= right) {
            ListNode node = temp;
            if (i < left)
                prev = temp;
            temp = temp.next;
            if (i >= left) {
                if (i == left) end = node;
                node.next = currHead;
                currHead = node;
            }
            i++;
        }
        end.next = temp;
        if (left == 1)
            head = currHead;
        else
            prev.next = currHead;
        return head;
    }

    public static void main(String[] args) {

    }

}
