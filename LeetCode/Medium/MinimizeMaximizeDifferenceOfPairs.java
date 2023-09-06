package LeetCode.Medium;

import java.util.Arrays;

public class MinimizeMaximizeDifferenceOfPairs {

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxDiff = Math.abs(nums[0] - nums[n - 1]);
        int start = 0;
        int end = maxDiff;
        int result = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = 0;
            int pairs = 0;
            while (i < n - 1) {
                if (pairs == p) break;
                if (Math.abs(nums[i] - nums[i + 1]) <= mid) {
                    i += 2;
                    pairs++;
                } else
                    i += 1;
            }
            if (pairs == p) {
                if (mid < result) result = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
