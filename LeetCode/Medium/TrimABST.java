package LeetCode.Medium;

import LeetCode.Model.TreeNode;

public class TrimABST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root.val >= low && root.val <= high ? root : null;
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        if (root.val >= low && root.val <= high)
            return root;
        return root.left == null ? root.right : root.left;
    }

    public static void main(String[] args) {

    }

}
