package LeetCode.Medium;

import LeetCode.Model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderPostorder {

    // O(N) time & space complexity solution - Using HashMap can reduce the time complexity to search index in inorder array to O(1).
    public int postOrderIndex = -1;

    public TreeNode helper(int start, int end, int[] postorder, Map<Integer, Integer> inorderMap) {
        if (start > end || postOrderIndex == -1)
            return null;
        int i = inorderMap.get(postorder[postOrderIndex]);
        TreeNode head = new TreeNode(postorder[postOrderIndex]);
        postOrderIndex--;
        head.right = helper(i + 1, end, postorder, inorderMap);
        head.left = helper(start, i - 1, postorder, inorderMap);
        return head;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        int n = postorder.length;
        for (int i = 0; i < n; i++) inorderMap.put(inorder[i], i);
        this.postOrderIndex = n - 1;
        return helper(0, n - 1, postorder, inorderMap);
    }
    //-----------------
    // O(N^2) time & O(1) space complexity solution -> Searching in inorder takes O(N) for each postorder index. So O(N^2).
    // ----------------
    // public int postOrderIndex = -1;
    // public TreeNode helper(int start, int end, int[] inorder, int[] postorder) {
    //     if (start > end || postOrderIndex == -1)
    //         return null;
    //     int i;
    //     for (i = start; i <= end; i++) {
    //         if (inorder[i] == postorder[postOrderIndex])
    //             break;
    //     }
    //     TreeNode head = null;
    //     if (i <= end) {
    //         head = new TreeNode(inorder[i]);
    //         postOrderIndex--;
    //         head.right = helper(i + 1, end, inorder, postorder);
    //         head.left = helper(start, i - 1, inorder, postorder);
    //     }
    //     return head;
    // }

    // public TreeNode buildTree(int[] inorder, int[] postorder) {
    //     int n = postorder.length;
    //     this.postOrderIndex = n - 1;
    //     return helper(0, n - 1, inorder, postorder);
    // }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        BinaryTreeFromInorderPostorder obj = new BinaryTreeFromInorderPostorder();
        TreeNode head = obj.buildTree(inorder, postorder);
        System.out.println(head);

    }

}
