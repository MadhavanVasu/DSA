package LeetCode.Medium;

import java.util.Arrays;

public class CoinChange2 {

    public int helper(int i, int amount, int[] coins, int[][] dp, int n) {
        if (amount == 0) return 0;
        if (i >= n) return 0;
        if (coins[i] == amount) return 1;
        if (coins[i] > amount) return 0;
        if (dp[i][amount] != -1) return dp[i][amount];
        int a = helper(i, amount - coins[i], coins, dp, n);
        int b = helper(i + 1, amount, coins, dp, n);
        dp[i][amount] = a + b;
        return dp[i][amount];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= amount; j++) dp[i][j] = -1;
        return helper(0, amount, coins, dp, n);
    }

    public static void main(String[] args) {

    }

}
