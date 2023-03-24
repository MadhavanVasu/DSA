package LeetCode.Easy;

import LeetCode.Model.TreeNode;

public class MinDistBetNodes {

    int prev = -1;
    int min = -1;

    public int minDiffInBST(TreeNode root) {

        if(root==null)
            return 0;
        minDiffInBST(root.left);
        if(prev!=-1 && (root.val - prev<min || min == -1))
            min = root.val - prev;
        prev = root.val;
        minDiffInBST(root.right);
        return min;
    }

    public static void main(String[] args) {

    }

}
