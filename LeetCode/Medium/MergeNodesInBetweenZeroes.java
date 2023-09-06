package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class MergeNodesInBetweenZeroes {

    public ListNode mergeNodesWithoutSpace(ListNode head) {
        ListNode result = head;
        ListNode prev = null;
        ListNode temp = head;
        int sum = head.next.val;
        temp = head.next.next;
        while (temp != null) {
            if (temp.val == 0) {
                result.val = sum;
                prev = result;
                result = result.next;
                sum = 0;
            } else sum += temp.val;
            temp = temp.next;
        }
        prev.next = null;
        return head;
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int sum = head.next.val;
        head = head.next.next;
        while (head != null) {
            if (head.val == 0) {
                ListNode node = new ListNode();
                node.val = sum;
                node.next = null;
                temp.next = node;
                temp = temp.next;
                sum = 0;
            } else sum += head.val;
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {

    }

}
