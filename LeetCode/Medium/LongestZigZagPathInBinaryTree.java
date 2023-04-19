package LeetCode.Medium;

import LeetCode.Model.TreeNode;

public class LongestZigZagPathInBinaryTree {

    int max = 0;

    public int helper(TreeNode root, int path) {
        if (root == null) return -1;
        int a = 0;
        int b = 0;
        if (path == 0) {
            a = 1 + helper(root.left, 1);
            b = 1 + helper(root.right, 0);
        } else {
            a = 1 + helper(root.right, 0);
            b = 1 + helper(root.left, 1);
        }
        max = Math.max(a, b);
        return a;
    }

    public int longestZigZag(TreeNode root) {
        helper(root, 0);
        return max;
    }

}
