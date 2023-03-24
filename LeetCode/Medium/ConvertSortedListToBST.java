package LeetCode.Medium;

import LeetCode.Model.ListNode;
import LeetCode.Model.TreeNode;

public class ConvertSortedListToBST {

    public static TreeNode helper(ListNode start, ListNode end) {
        if (start == null)
            return null;
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode head = new TreeNode(slow.val);
        if (start == slow)
            head.left = null;
        else
            head.left = helper(start, slow);

        if (slow.next == end)
            head.right = null;
        else
            head.right = helper(slow.next, end);
        return head;
    }

    public TreeNode sortedListToBST(ListNode head) {

        return helper(head, null);

    }

    public static void main(String[] args) {

    }

}
