package LeetCode.Medium;

import LeetCode.Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currDepth = 1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            boolean rowAddedFlag = false;
            while (qSize-- != 0) {
                TreeNode node = queue.poll();
                if (currDepth == depth - 1) {
                    rowAddedFlag = true;
                    TreeNode newNode = new TreeNode(val);
                    newNode.left = node.left;
                    node.left = newNode;
                    newNode = new TreeNode(val);
                    newNode.right = node.right;
                    node.right = newNode;
                } else {
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            currDepth++;
            if (rowAddedFlag) break;
        }
        return root;
    }

    public static void main(String[] args) {

    }

}
