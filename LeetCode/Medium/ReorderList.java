package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class ReorderList {

    public ListNode reverseList(ListNode curr, ListNode next) {
        if (next == null) return curr;
        ListNode temp = next.next;
        next.next = curr;
        return reverseList(next, temp);
    }

    public void reorderList(ListNode head) {
        ListNode oddNodes = new ListNode();
        ListNode evenNodes = new ListNode();
        ListNode temp1 = oddNodes;
        ListNode temp2 = evenNodes;
        int i = 1;
        while (head != null) {
            if (i % 2 != 0) {
                temp1.next = head;
                temp1 = temp1.next;
                head = head.next;
            } else {
                temp2.next = head;
                temp2 = temp2.next;
                head = head.next;
            }
            i++;
        }
        temp1.next = temp2.next = null;
        reverseList(evenNodes, null);
        ListNode temp = new ListNode();
        while (oddNodes != null) {
            temp.next = oddNodes;
            oddNodes = oddNodes.next;
            temp = temp.next;
            if (evenNodes != null) {
                temp.next = evenNodes;
                evenNodes = evenNodes.next;
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public static void main(String[] args) {

    }

}
