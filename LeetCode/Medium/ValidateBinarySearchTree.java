package LeetCode.Medium;

import LeetCode.Model.TreeNode;

public class ValidateBinarySearchTree {

    boolean result = true;
    Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        if(!result)
            return false;
        if(root==null)
            return true;
        isValidBST(root.left);
        if(prev==null || root.val>prev)
            prev = root.val;
        else
            result = false;
        isValidBST(root.right);
        return result;
    }

    public static void main(String[] args) {

    }

}
