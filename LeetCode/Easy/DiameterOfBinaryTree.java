package LeetCode.Easy;

import LeetCode.Model.TreeNode;

public class DiameterOfBinaryTree {

    public int maxDiameter = 0;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return -1;
        int a = 1 + maxDepth(root.left);
        int b = 1 + maxDepth(root.right);
        if (a + b > maxDiameter)
            maxDiameter = a + b;
        return Math.max(a, b);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public static void main(String[] args) {

    }

}
