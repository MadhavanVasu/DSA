package LeetCode.Medium;

public class MinimumNumberOfCoinsForFruits {

    public int helper(int i, int[] prices, int n, Integer[] dp) {
        if (i >= n) return 0;
        if (dp[i] != null) return dp[i];
        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j < i + i + 3 && j < n; j++) {
            int temp = helper(j, prices, n, dp);
            if (temp < min) {
                min = temp;
            }
        }
        if (min == Integer.MAX_VALUE) min = 0;
        dp[i] = prices[i] + min;
        return dp[i];
    }

    public int minimumCoins(int[] prices) {
        int n = prices.length;
        Integer[] dp = new Integer[n];
        return helper(0, prices, n, dp);
    }

    public static void main(String[] args) {

    }

}
