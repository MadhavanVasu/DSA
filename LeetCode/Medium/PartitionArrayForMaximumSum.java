package LeetCode.Medium;

public class PartitionArrayForMaximumSum {

    public int helper(int i, int curr, int k, Integer[][] dp, int[] arr, int max, int n) {
        if (i >= n) {
            if (max == Integer.MIN_VALUE) return 0;
            return (curr - 1) * max;
        }
        if (dp[i][curr] != null) return dp[i][curr];
        if (arr[i] > max) max = arr[i];
        int a = 0;
        if (curr < k) {
            a = helper(i + 1, curr + 1, k, dp, arr, max, n);
        }
        int b = (curr * max) + helper(i + 1, 1, k, dp, arr, Integer.MIN_VALUE, n);
        dp[i][curr] = Math.max(a, b);
        return dp[i][curr];
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        Integer[][] dp = new Integer[n][k + 1];
        return helper(0, 1, k, dp, arr, Integer.MIN_VALUE, n);
    }

    public static void main(String[] args) {
        System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(new int[]{1, 2, 3}, 2));
    }

}
