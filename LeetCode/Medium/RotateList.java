package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            n++;
            temp = temp.next;
        }
        k = k%n;
        if(k==0 || head==null)
            return head;
        int i = 0;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null)
        {
            if(i>=k)
                slow = slow.next;
            fast = fast.next;
            i++;
        }
        if(i<k)
            return head;
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i=2; i<=5; i++)
        {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode newHead = rotateRight(head, 5);
        temp = newHead;
        while(temp!=null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}
