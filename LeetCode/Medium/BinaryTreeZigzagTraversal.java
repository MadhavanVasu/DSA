package LeetCode.Medium;

import LeetCode.Model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int i = 0;
        while(!stack.isEmpty())
        {
            List<Integer> levelTraversal = new ArrayList<>();
            int stackSize = stack.size();
            Stack<TreeNode> tempStack = new Stack<>();
            while(stackSize--!=0)
            {
                TreeNode node = stack.pop();
                System.out.println(node);
                levelTraversal.add(node.val);
                if(i%2==0)
                {
                    if(node.left!=null) {
                        tempStack.push(node.left);
                    }
                    if(node.right!=null)
                        tempStack.push(node.right);
                }
                else
                {
                    if(node.right!=null)
                        tempStack.push(node.right);
                    if(node.left!=null)
                        tempStack.push(node.left);
                }
            }
            result.add(levelTraversal);
            stack.addAll(tempStack);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
        System.out.println(5|6);
    }
}
