package LeetCode.Medium;

import LeetCode.Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        int level = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int prev = 0;
        while (!queue.isEmpty()) {
            level++;
            if (level % 2 == 0) prev = Integer.MIN_VALUE;
            else prev = Integer.MAX_VALUE;
            int qSize = queue.size();
            while (qSize-- != 0) {
                TreeNode node = queue.poll();
                if (!(level % 2 == 0 && node.val > prev) || !(level % 2 != 0 && node.val < prev)) return false;
                prev = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {


    }

}
