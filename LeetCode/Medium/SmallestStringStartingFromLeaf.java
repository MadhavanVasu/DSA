package LeetCode.Medium;

import LeetCode.Model.TreeNode;

public class SmallestStringStartingFromLeaf {

    String result = null;

    public boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    public void helper(TreeNode root, StringBuilder sb) {
        if (isLeaf(root)) {
            sb.append((char) ('a' + root.val));
            String s = sb.reverse().toString();
            if (result == null || result.compareTo(s) > 0) result = s;
        } else {
            sb.append((char) ('a' + root.val));
            if (root.left != null)
                helper(root.left, new StringBuilder(sb));
            if (root.right != null)
                helper(root.right, new StringBuilder(sb));
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        helper(root, new StringBuilder());
        return result;
    }

    public static void main(String[] args) {

    }

}
