package LeetCode.Medium;

import LeetCode.Model.TreeNode;

import java.util.*;

public class AmountOfTimeForBinaryTreeInfected {


    public void inorderTraversal(TreeNode root, Map<Integer, Set<Integer>> adjNodeMap) {
        if (root == null) return;
        Set<Integer> adjSet = adjNodeMap.getOrDefault(root, new HashSet<>());
        if (root.left != null) {
            adjSet.add(root.left.val);
            Set<Integer> leftAdj = adjNodeMap.getOrDefault(root.left.val, new HashSet<>());
            leftAdj.add(root.val);
            adjNodeMap.put(root.left.val, leftAdj);
        }
        if (root.right != null) {
            adjSet.add(root.right.val);
            Set<Integer> rightAdj = adjNodeMap.getOrDefault(root.right.val, new HashSet<>());
            rightAdj.add(root.val);
            adjNodeMap.put(root.right.val, rightAdj);
        }
        adjNodeMap.put(root.val, adjSet);
        inorderTraversal(root.left, adjNodeMap);
        inorderTraversal(root.right, adjNodeMap);
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> adjNodesMap = new HashMap<>();
        inorderTraversal(root, adjNodesMap);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int minute = -1;
        while (!queue.isEmpty()) {
            minute++;
            int qSize = queue.size();
            while (qSize-- != 0) {
                int node = queue.poll();
                for (int x : adjNodesMap.get(node)) {
                    if (!visited.contains(x)) {
                        visited.add(x);
                        queue.add(x);
                    }
                }
            }
        }
        return minute - 1;
    }

    public static void main(String[] args) {

    }

}
