package LeetCode.Medium;

import LeetCode.Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {

        int result = -1;
        long sum = 0;
        long max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            int qSize = queue.size();
            level++;
            while (qSize-- != 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
            if (sum > max || result == -1) {
                max = sum;
                result = level;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
