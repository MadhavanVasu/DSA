package Easy;

import LeetCode.Model.ListNode;

public class MergeSortedLL {

    //Using recursion
    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //Iterative approach
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode sortedList = new ListNode(0);
        ListNode head = sortedList;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                head = head.next;
                list1 = list1.next;

            } else {
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }
        head.next = list1 == null ? list2 : list1;
        return sortedList.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode temp = head1;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode head2 = new ListNode(6);
        temp = head2;
        for (int i = 7; i <= 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode sorted = mergeTwoLists(head2, head1);
        while (sorted != null) {
            System.out.println(sorted.val);
            sorted = sorted.next;
        }
    }
}
