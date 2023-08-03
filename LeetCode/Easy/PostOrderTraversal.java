package LeetCode.Easy;

import LeetCode.Model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        if (root == null) return result;
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            stack.push(node.val);
            if (node.left != null)
                nodes.push(node.left);
            if (node.right != null)
                nodes.push(node.right);
        }
        while (!stack.isEmpty())
            result.add(stack.pop());
        return result;
    }


    public static void main(String[] args) {

    }

}
