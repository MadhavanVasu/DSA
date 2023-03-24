package LeetCode.Medium;

import java.util.Arrays;

public class MaximumProductSubarr {

    public static double findMax(int[] nums, int i, double[] dp, int n, double prod) {
        if (i >= n)
            return prod;
        if(dp[i]!=Double.NEGATIVE_INFINITY && prod*nums[i]<dp[i])
            return dp[i];
        int a = nums[i];
        double b = prod;
        if (prod == Double.NEGATIVE_INFINITY)
            prod = 1;
        double c = findMax(nums, i + 1, dp, n, prod * nums[i]);
        double d = findMax(nums, i + 1, dp, n, Double.NEGATIVE_INFINITY);
        dp[i] = Math.max(Math.max(Math.max(a, b), c), d);
        System.out.println(Arrays.toString(dp));
        return dp[i];
    }

    public static int maxProduct(int[] nums) {

        int n = nums.length;
        double[] dp = new double[n];
        for (int i = 0; i < n; i++)
            dp[i] = Double.NEGATIVE_INFINITY;

        return (int) findMax(nums, 0, dp, n, Double.NEGATIVE_INFINITY);

    }

    public static void main(String[] args) {
        int[] nums = {-2, -3, -2, 4,8};

        System.out.println(maxProduct(nums));
    }

}
