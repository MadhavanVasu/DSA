//package LeetCode.Medium;
//
//import LeetCode.Model.TreeNode;
//
//import java.util.Set;
//
//public class PseudoPalindromicPathsInBinaryTree {
//
//    int result = 0;
//
//    public boolean isLeaf(TreeNode root) {
//        return root.left == null && root.right == null;
//    }
//
//    public void helper(TreeNode root, Set<Integer> set) {
//        if (root == null) return;
//        int[] digitCountClone = digitCount.clone();
//        digitCountClone[root.val]++;
//        int oddCount = 0;
//        for (int x : digitCountClone) if (x % 2 == 1) oddCount++;
//        if (oddCount <= 1 && isLeaf(root)) result++;
//        helper(root.left, digitCountClone);
//        helper(root.right, digitCountClone);
//
//        0 1
//        1 0
//
//        1 4 2 2
//    }
//
//    public int pseudoPalindromicPaths(TreeNode root) {
//        helper(root, new int[10]);
//        return result;
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
