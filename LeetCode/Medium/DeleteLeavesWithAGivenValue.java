package LeetCode.Medium;

import LeetCode.Model.TreeNode;

public class DeleteLeavesWithAGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.left, target);
        root.left = left;
        root.right = right;
        if (left == null && right == null && root.val == target) return null;
        return root;
    }

    public static void main(String[] args) {

    }

}
