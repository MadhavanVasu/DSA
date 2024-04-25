package LeetCode.Easy;

import LeetCode.Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

    int leavesCount = 0;

    public boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public void helper(TreeNode root, boolean isLeft) {
        if (root == null) return;
        if (isLeaf(root)) {
            if (isLeft) leavesCount += root.val;
        } else {
            helper(root.left, true);
            helper(root.right, false);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return leavesCount;
    }

    public class QueueElement {
        TreeNode node;
        boolean isLeft;

        public QueueElement(TreeNode node, boolean isLeft) {
            this.node = node;
            this.isLeft = isLeft;
        }
    }

    public int sumOfLeftLeavesUsingBFS(TreeNode root) {
        int sum = 0;
        Queue<QueueElement> q = new LinkedList<>();
        q.add(new QueueElement(root, false));
        while (!q.isEmpty()) {
            QueueElement ele = q.poll();
            TreeNode node = ele.node;
            if (isLeaf(node) && ele.isLeft) sum += node.val;
            if (node.left != null) q.add(new QueueElement(node.left, true));
            if (node.right != null) q.add(new QueueElement(node.right, false));
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
