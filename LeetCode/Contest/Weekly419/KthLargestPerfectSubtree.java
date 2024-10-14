package LeetCode.Contest.Weekly419;

import LeetCode.Model.TreeNode;

import java.util.PriorityQueue;

public class KthLargestPerfectSubtree {

    public int helper(TreeNode root, PriorityQueue<Integer> pq, int k) {
        if (root == null) return 0;
        int a = helper(root.left, pq, k);
        int b = helper(root.right, pq, k);
        if (b != -1 && a == b) {
            int nodes = a + b + 1;
            if (pq.size() < k) pq.add(nodes);
            else if (pq.peek() < nodes) {
                pq.poll();
                pq.add(nodes);
            }
            return nodes;
        }
        return -1;
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        helper(root, pq, k);
        if (pq.size() < k) return -1;
        return pq.poll();
    }

    public static void main(String[] args) {

    }

}
