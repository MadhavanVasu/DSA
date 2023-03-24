package LeetCode.Easy;

import LeetCode.Model.TreeNode;

public class ConstructStringFromTree {
    String result = "";

    public String tree2str(TreeNode root) {
        if (root == null)
            return result;
        result += root.val;
        if (root.left != null || root.right != null) {
            result += "(";
            tree2str(root.left);
            result += ")";
            if (root.right != null) {
                result += "(";
                tree2str(root.right);
                result += ")";
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
