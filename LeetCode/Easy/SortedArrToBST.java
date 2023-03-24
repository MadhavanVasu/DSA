package LeetCode.Easy;

import LeetCode.Model.TreeNode;

public class SortedArrToBST {

    public static TreeNode getHead(int start, int end, int[] nums) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = getHead(0, mid - 1, nums);
        head.right = getHead(mid + 1, end, nums);
        return head;
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return getHead(0, nums.length - 1, nums);

    }

    public static void main(String[] args) {

    }

}
