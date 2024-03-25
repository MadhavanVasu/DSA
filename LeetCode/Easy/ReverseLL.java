package LeetCode.Easy;

import LeetCode.Model.ListNode;

public class ReverseLL {
    public ListNode reverseListRecursion(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }
    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode revHead = head;
        ListNode nextHead = head.next;
        revHead.next = null;
        while(nextHead!=null)
        {
            ListNode temp = nextHead.next;
            nextHead.next = revHead;
            revHead = nextHead;
            nextHead = temp;
        }
        return revHead;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 2; i<=5; i++)
        {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode reverse = reverseList(head);
        while(reverse!=null)
        {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
