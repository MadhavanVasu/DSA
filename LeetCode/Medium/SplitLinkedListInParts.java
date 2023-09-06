package LeetCode.Medium;

import LeetCode.Model.ListNode;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        int partitionSize = n / k;
        int remNodes = n % k;

        temp = head;
        ListNode[] result = new ListNode[k];
        int i = 0;
        while (k != 0) {
            int nodesToAdd = partitionSize;
            if (remNodes > 0) {
                nodesToAdd++;
                remNodes--;
            }
            if (nodesToAdd == 0 || temp == null)
                result[i] = null;
            else {
                result[i] = temp;
                ListNode prev = null;
                while (nodesToAdd > 0) {
                    prev = temp;
                    temp = temp.next;
                    nodesToAdd--;
                }
                prev.next = null;
            }
            k--;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
