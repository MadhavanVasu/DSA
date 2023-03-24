package LeetCode.Easy;

import LeetCode.Model.ListNode;

public class RemoveDuplicatesFromSortedLL {

    public ListNode helper(ListNode head, ListNode prev)
    {
        if(head==null)
            return null;
        if(prev==null || prev.val==head.val)
            head.next = helper(head.next, head);
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr!=null)
        {
            if(curr.val!=prev.val)
            {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }

    public static void main(String[] args) {

    }

}
