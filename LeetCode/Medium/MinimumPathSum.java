package LeetCode.Medium;

public class MinimumPathSum {

    public static int minPathSumBottomUp(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = grid[n - 1][m - 1];
        for (int j = m - 2; j >= 0; j--)
            dp[n - 1][j] = dp[n - 1][j + 1] + grid[n - 1][j];
        for (int i = n - 2; i >= 0; i--)
            dp[i][m - 1] = dp[i + 1][m - 1] + grid[i][m - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];

    }

    public static int helper(int i, int j, int[][] grid, int n, int m, int[][] dp) {
        if (i == n - 1 && j == m - 1)
            return grid[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        if (j + 1 < m)
            a = grid[i][j] + helper(i, j + 1, grid, n, m, dp);
        if (i + 1 < n)
            b = grid[i][j] + helper(i + 1, j, grid, n, m, dp);
        dp[i][j] = Math.min(a, b);
        return dp[i][j];
    }

    public static int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                dp[i][j] = -1;
        }
        return helper(0, 0, grid, n, m, dp);

    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(minPathSum(grid));

    }

}
