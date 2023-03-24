package LeetCode.Easy;

import LeetCode.Model.TreeNode;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

        if(root==null)
            return 0;
        int a = 1 + maxDepth(root.left);
        int b = 1 + maxDepth(root.right);
        return Math.max(a,b);

    }

    public static void main(String[] args) {

    }

}
