package LeetCode.Easy;

import LeetCode.Model.TreeNode;

import java.util.*;

public class FindModeInBinarySearchTree {

    List<Integer> result = new ArrayList<>();
    int maxCount = 0;
    Integer prev = null;
    int currCount = 0;

    public void inOrderTraversal(TreeNode node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        if (prev != null && prev == node.val) {
            currCount += 1;
        } else {
            currCount = 1;
            prev = node.val;
        }
        if (currCount > maxCount) {
            maxCount = currCount;
            result = new ArrayList<>();
            result.add(node.val);
        } else if (currCount == maxCount) {
            result.add(node.val);
        }
        inOrderTraversal(node.right);
    }

    public int[] findModeOptimal(TreeNode root) {
        inOrderTraversal(root);
        int size = result.size();
        int[] ans = new int[size];
        int i = 0;
        for (int x : result) ans[i++] = x;
        return ans;
    }

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            frequencyMap.put(node.val, frequencyMap.getOrDefault(node.val, 0) + 1);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int max = 0;
        for (int x : frequencyMap.keySet()) {
            max = Math.max(max, frequencyMap.get(x));
        }
        List<Integer> result = new ArrayList<>();
        for (int x : frequencyMap.keySet()) {
            if (frequencyMap.get(x) == max)
                result.add(x);
        }
        int[] arr = new int[result.size()];
        int i = 0;
        for (int x : result)
            arr[i++] = x;
        return arr;
    }


    public static void main(String[] args) {

    }

}
