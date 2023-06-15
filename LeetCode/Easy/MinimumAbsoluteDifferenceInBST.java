package LeetCode.Easy;

import LeetCode.Model.TreeNode;

public class MinimumAbsoluteDifferenceInBST {

    int prev = -1;

    Integer min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        if (root == null) return min;
        getMinimumDifference(root.left);
        if (prev != -1) {
            int diff = Math.abs(root.val - prev);
            if (diff < min) min = diff;
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;

    }

    public static void main(String[] args) {

    }

}
