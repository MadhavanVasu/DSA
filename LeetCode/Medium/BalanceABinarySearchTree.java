package LeetCode.Medium;

import LeetCode.Model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {

    public void inorderTraversal(TreeNode root, List<Integer> sortedArr) {
        if (root == null) return;
        inorderTraversal(root.left, sortedArr);
        sortedArr.add(root.val);
        inorderTraversal(root.right, sortedArr);
    }

    public TreeNode helper(List<Integer> arr, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = helper(arr, start, mid - 1);
        root.right = helper(arr, mid + 1, end);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedArr = new ArrayList<>();
        inorderTraversal(root, sortedArr);
        return helper(sortedArr, 0, sortedArr.size() - 1);
    }

    public static void main(String[] args) {

    }

}
