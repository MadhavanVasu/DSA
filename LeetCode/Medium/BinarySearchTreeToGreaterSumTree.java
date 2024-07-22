package LeetCode.Medium;

import LeetCode.Model.TreeNode;

public class BinarySearchTreeToGreaterSumTree {

    public boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    public int helper(TreeNode root, int sum) {
        if (isLeaf(root)) {
            sum += root.val;
            root.val = sum;
            return sum;
        }
        if (root.right != null)
            sum = helper(root.right, sum);
        sum += root.val;
        root.val = sum;
        if (root.left != null)
            sum = helper(root.left, sum);
        return sum;
    }

    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    public static void main(String[] args) {

    }

}
