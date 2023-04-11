package LeetCode.Medium;

import java.util.Arrays;

public class MinimumMaximumOfArray {

    public static boolean isFeasible(int max, int[] nums) {
        long have = 0;
        for (int x : nums) {
            if (x <= max)
                have += (max - x);
            else {
                long need = x - max;
                if (need > have) return false;
                have -= need;
            }
        }
        return true;
    }

    public static int minimizeArrayValueBinarySearch(int[] nums) {
        int start = 0;
        int end = Arrays.stream(nums).max().orElse(0);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isFeasible(mid, nums))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public static int minimizeArrayValue(int[] nums) {
        long prefixSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum += nums[i];
            if (Math.ceil(prefixSum / (double) (i + 1)) > max)
                max = (int) Math.ceil((double) prefixSum / (i + 1));
        }
        return max;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 4, 5, 7};
//        int[] nums = {3,7,1,6};
//        int[] nums = {9,1,10,11};
//        int[] nums = {10,1};
        int[] nums = {13, 13, 20, 0, 8, 9, 9};
        System.out.println(minimizeArrayValue(nums));

    }

}
