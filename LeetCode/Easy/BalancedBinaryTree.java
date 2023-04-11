package LeetCode.Easy;

import LeetCode.Model.TreeNode;

public class BalancedBinaryTree {

    public int height(TreeNode root)
    {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(height(root.right) - height(root.left))<=1 && isBalanced(root.right) && isBalanced(root.left);
    }

    public static void main(String[] args) {

    }

}
