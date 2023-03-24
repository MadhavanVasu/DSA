package LeetCode.Medium;

import LeetCode.Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfTree {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean f = false;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- != 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    f = true;
                    continue;
                }
                if (f)
                    return false;
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
