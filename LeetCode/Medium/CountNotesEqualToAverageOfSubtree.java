package LeetCode.Medium;

import LeetCode.Model.TreeNode;

public class CountNotesEqualToAverageOfSubtree {

    int count = 0;

    public int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] leftSubtree = helper(root.left);
        int[] rightSubtree = helper(root.right);
        int total = leftSubtree[0] + rightSubtree[0] + 1;
        int sum = leftSubtree[1] + rightSubtree[1] + root.val;
        int avg = Math.round((float) sum / total);
        if (avg == root.val) count += 1;
        return new int[]{total, sum};
    }

    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }

    public static void main(String[] args) {

    }

}
