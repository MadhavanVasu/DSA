package LeetCode.Medium;

public class UniquePaths2 {

    public int helper(int i, int j, int n, int m, int[][] obstacleGrid, Integer[][] dp) {
        if (i >= n || j >= m) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        if (i == n - 1 && j == m - 1) return 1;
        if (dp[i][j] != null) return dp[i][j];
        int a = helper(i + 1, j, n, m, obstacleGrid, dp);
        int b = helper(i, j + 1, n, m, obstacleGrid, dp);
        dp[i][j] = a + b;
        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        Integer[][] dp = new Integer[n][m];
        return helper(0, 0, n, m, obstacleGrid, dp);
    }

    public static void main(String[] args) {

    }

}
