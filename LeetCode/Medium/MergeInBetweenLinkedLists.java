package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i = 0;
        ListNode result = new ListNode();
        ListNode head = result;
        while (list1 != null) {
            if(i <= a - 1 || i > b)
            {
                result.next = new ListNode(list1.val);
                result = result.next;
            }
            if (i == a - 1) {
                while (list2 != null)
                {
                    result.next = new ListNode(list2.val);
                    list2 = list2.next;
                    result = result.next;
                }
            }
            list1 = list1.next;
            i++;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }

}
