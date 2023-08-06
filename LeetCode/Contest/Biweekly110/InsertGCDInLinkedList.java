package LeetCode.Contest.Biweekly110;

import LeetCode.Model.ListNode;

public class InsertGCDInLinkedList {

    public int gcd(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode temp = head;
        while (temp.next != null) {
            int a = temp.val;
            int b = temp.next.val;
            int newVal = gcd(a, b);
            ListNode newNode = new ListNode();
            newNode.val = newVal;
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        return head;

    }

    public static void main(String[] args) {

    }

}
