package LeetCode.Contest.Weekly357;

import java.util.List;

public class PossbileToSplitArray {

    public boolean helper(int start, int end, List<Integer> nums, int m, int n, int[] prefixSum, Boolean[][] dp) {

        if (start == end || start + 1 == end) return true;
        if (dp[start][end] != null) return dp[start][end];

        boolean a = false;
        boolean b = false;
        int removeStart = prefixSum[end] - prefixSum[start];
        int removeEnd = prefixSum[end - 1];
        if (start != 0)
            removeEnd -= prefixSum[start - 1];
        if (removeStart >= m)
            a = helper(start + 1, end, nums, m, n, prefixSum, dp);
        if (removeEnd >= m)
            b = helper(start, end - 1, nums, m, n, prefixSum, dp);
        dp[start][end] = a || b;
        return dp[start][end];
    }

    public boolean canSplitArray(List<Integer> nums, int m) {

        int n = nums.size();
        int[] prefixSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums.get(i);
            prefixSum[i] = sum;
        }
        Boolean[][] dp = new Boolean[n][n];
        return helper(0, nums.size() - 1, nums, m, nums.size(), prefixSum, dp);

    }

    public static void main(String[] args) {

    }

}
