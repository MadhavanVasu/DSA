package LeetCode.Medium;

import LeetCode.Model.TreeNode;

public class SumRootToLeafNumbers {

    public static int sum = 0;

    public static void helper(TreeNode root, int num) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum += (num * 10 + root.val);
            return;
        }
        helper(root.left, num * 10 + root.val);
        helper(root.right, num * 10 + root.val);
    }

    public static int sumNumbers(TreeNode root) {

        helper(root, 0);
        return sum;


    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));

    }

}
