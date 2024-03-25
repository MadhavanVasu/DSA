package LeetCode.Medium;

import LeetCode.Model.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodes {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        int sum = 0;
        while (temp.next != null) {
            Map<Integer, ListNode> sumMap = new HashMap<>();
            temp = temp.next;
            while (temp.next != null) {
                sum += temp.val;
                if (sumMap.containsKey(sum)) {
                    ListNode temp2 = dummy;
                    while (temp2.next != sumMap.get(sum)) temp2 = temp2.next;
                    temp2.next = temp.next;
                    temp = dummy;
                } else if (sum == 0) {
                    dummy.next = temp.next;
                    temp = dummy;
                } else sumMap.put(sum, temp);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }

}
