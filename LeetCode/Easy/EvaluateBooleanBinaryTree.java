package LeetCode.Easy;

import LeetCode.Model.TreeNode;

public class EvaluateBooleanBinaryTree {

    public boolean evaluateTree(TreeNode root) {

        if (root.left == null && root.right == null) return root.val == 1;
        boolean a = evaluateTree(root.left);
        boolean b = evaluateTree(root.right);
        if (root.val == 2) return a || b;
        else return a && b;

    }

    public static void main(String[] args) {

    }

}
