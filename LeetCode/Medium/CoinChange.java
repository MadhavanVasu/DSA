package LeetCode.Medium;

import java.util.Arrays;

public class CoinChange {

    public int helper(int i, int amount, int[] coins, Integer[][] dp, int n) {
        if (amount == 0) return 0;
        if (i == n) return Integer.MAX_VALUE;
        if (dp[i][amount] != null) return dp[i][amount];
        int min = Integer.MAX_VALUE;
        for (int j = 1; coins[i] * j <= amount; j++) {
            int a = helper(i + 1, amount - coins[i] * j, coins, dp, n);
            if (a != Integer.MAX_VALUE)
                min = Math.min(a + j, min);
        }
        int b = helper(i + 1, amount, coins, dp, n);
        dp[i][amount] = Math.min(min, b);
        return dp[i][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int result = helper(0, amount, coins, new Integer[coins.length][amount + 1], coins.length);
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }

    public static void main(String[] args) {

    }

}
