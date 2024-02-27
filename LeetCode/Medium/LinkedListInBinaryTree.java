package LeetCode.Medium;

import LeetCode.Model.ListNode;
import LeetCode.Model.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListInBinaryTree {

    public boolean isValidSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val == root.val) {
            boolean a = isValidSubPath(head.next, root.left);
            boolean b = isValidSubPath(head.next, root.right);
            return a || b;
        }
        return false;
    }

    public boolean isSubPath2(ListNode head, TreeNode root) {
        boolean valid = isValidSubPath(head, root);
        if (valid) return true;
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean helper(ListNode currHead, TreeNode root, ListNode head, Map<TreeNode, Map<ListNode, Boolean>> dp) {
        if (root == null) {
            return currHead == null;
        }
        if (currHead == null) return true;
        if (dp.containsKey(root) && dp.get(root).containsKey(currHead)) return dp.get(root).get(currHead);
        boolean a = false;
        boolean b = false;
        if (root.val == currHead.val) {
            a = helper(currHead.next, root.left, head, dp);
            b = helper(currHead.next, root.right, head, dp);
        }
        boolean c = helper(head, root.left, head, dp);
        boolean d = helper(head, root.right, head, dp);
        Map<ListNode, Boolean> map = dp.getOrDefault(root, new HashMap<>());
        map.put(currHead, a || b || c || d);
        dp.put(root, map);
        return a || b || c || d;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        Map<TreeNode, Map<ListNode, Boolean>> dp = new HashMap<>();
        return helper(head, root, head, dp);
    }

    public static void main(String[] args) {

    }

}
