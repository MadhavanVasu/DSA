package LeetCode.Hard;

public class ProfitableSchemes {
    public static int helper(int i, int n, int currProfit, int minProfit, int[] group, int[] profit, int len, int[][][] dp) {
        if (i == len || n == 0) {
            if (minProfit <= currProfit) return 1;
            return 0;
        }
        if (dp[i][n][currProfit] != -1) return dp[i][n][currProfit];
        int a = 0;
        int b = 0;
        if (n >= group[i]) {
            a = helper(i + 1, n - group[i], currProfit + profit[i], minProfit, group, profit, len, dp) % 1000000007;
        }
        b = helper(i + 1, n, currProfit, minProfit, group, profit, len, dp) % 1000000007;
        dp[i][n][currProfit] = (a + b) % 1000000007;
        return dp[i][n][currProfit];
    }

    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int[][][] dp = new int[len][n + 1][10001];
        for (int i = 0; i < len; i++)
            for (int j = 0; j <= n; j++)
                for (int k = 0; k <= 10000; k++)
                    dp[i][j][k] = -1;
        return helper(0, n, 0, minProfit, group, profit, group.length, dp);
    }

    public static void main(String[] args) {

        int n = 10;
        int minProfit = 5;
        int[] group = {2, 3, 5};
        int[] profit = {6, 7, 8};
        System.out.println(profitableSchemes(n, minProfit, group, profit));

    }
}
