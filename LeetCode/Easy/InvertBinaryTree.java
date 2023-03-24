package LeetCode.Easy;

import LeetCode.Model.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
