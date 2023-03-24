package LeetCode.Medium;

import LeetCode.Model.TreeNode;

public class CountGoodNodes {

    public static int helper(TreeNode root, int max)
    {
        if(root==null)
            return 0;
        int res = 0;
        if(root.val>max){
            max = root.val;
            res = 1;
        }
        int a = helper(root.left, max);
        int b = helper(root.right, max);
        return res+a+b;
    }

    public int goodNodes(TreeNode root) {
        return helper(root,root.val);
    }

}
