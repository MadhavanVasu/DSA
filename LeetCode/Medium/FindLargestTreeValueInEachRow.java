package LeetCode.Medium;

import LeetCode.Model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestTreeValueInEachRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        if (root == null) return result;
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            int max = Integer.MIN_VALUE;
            while (size-- != 0) {
                TreeNode node = bfsQueue.poll();
                if (node.val > max) max = node.val;
                if (node.left != null) bfsQueue.add(node.left);
                if (node.right != null) bfsQueue.add(node.right);
            }
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
