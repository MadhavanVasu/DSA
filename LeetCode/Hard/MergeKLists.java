package LeetCode.Hard;

import LeetCode.Model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    // Optimal Solution - O(N log(N)) - using Heaps
    public static ListNode mergeKListsUsingHeaps(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode x : lists) {
            while (x != null) {
                pq.add(x);
                x = x.next;
            }
        }
        if (pq.isEmpty())
            return null;
        ListNode head = pq.poll();
        ListNode temp = head;
        while (!pq.isEmpty()) {
            temp.next = pq.poll();
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static ListNode merge2Lists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = merge2Lists(list1.next, list2);
            return list1;
        } else {
            list2.next = merge2Lists(list1, list2.next);
            return list2;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0)
            return new ListNode();
        if (n == 1)
            return lists[0];
        ListNode head = lists[0];
        for (int i = 1; i < n; i++) {
            head = merge2Lists(head, lists[i]);
        }
        return head;
    }

    public static void main(String[] args) {

    }

}
