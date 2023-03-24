package LeetCode.Medium;

import LeetCode.Model.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestLevelSum {

    public long kthLargestLevelSum(TreeNode root, int k) {

        PriorityQueue<Long> heap = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            long sum = 0;
            while (qSize-- != 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if (heap.size() < k)
                heap.add(sum);
            else if (heap.peek() < sum) {
                heap.poll();
                heap.add(sum);
            }
        }
        if (heap.size() < k)
            return -1;
        else return heap.poll();

    }

    public static void main(String[] args) {

    }

}
