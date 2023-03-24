package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null || fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
            {
                int n = 0;
                do{
                    fast = fast.next;
                    n++;
                }while (slow!=fast);
                int i = 0;
                slow = head;
                fast = head;
                while (fast.next!=slow)
                {
                    if(i>=n-1)
                        slow = slow.next;
                    fast = fast.next;
                    i++;
                }
                return slow;
            }
        }
        return null;

    }

    public static void main(String[] args) {

    }

}
