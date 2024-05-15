package LeetCode.Hard;

public class BuyAndSellStock3 {

    public static int helper(int i, int tradeDirection, int left, int[] prices, int n, int[] dp) {
        if (left == 0 && tradeDirection == 1)
            return 0;
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];
        int a, b;
        if (tradeDirection == 1) {
            a = -prices[i] + helper(i + 1, 0, left - 1, prices, n, dp);
            b = helper(i + 1, 1, left, prices, n, dp);
        } else {
            a = prices[i] + helper(i + 1, 1, left, prices, n, dp);
            b = helper(i + 1, 0, left, prices, n, dp);
        }
        dp[i] = Math.max(a, b);
        return dp[i];
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return helper(0, 1, 2, prices, prices.length, dp);
    }

    public static void main(String[] args) {

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));

    }

}
