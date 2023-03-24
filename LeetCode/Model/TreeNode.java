package LeetCode.Model;

//Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;


    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
