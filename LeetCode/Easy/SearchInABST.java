package LeetCode.Easy;

import LeetCode.Model.TreeNode;

public class SearchInABST {
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null)
            return null;
        if (root.val == val)
            return root;
        else if (root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);

    }

    public static void main(String[] args) {

    }
}
