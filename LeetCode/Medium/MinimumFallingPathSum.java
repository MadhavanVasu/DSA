package LeetCode.Medium;

public class MinimumFallingPathSum {
    public boolean isValid(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) dp[n - 1][m] = matrix[n - 1][m];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int min = Integer.MAX_VALUE;
                if (isValid(i + 1, j - 1, n, m)) {
                    int sum = matrix[i][j] + dp[i + 1][j - 1];
                    min = sum;
                }
                if (isValid(i + 1, j, n, m)) {
                    int sum = matrix[i][j] + dp[i + 1][j - 1];
                    min = Math.min(sum, min);
                }
                if (isValid(i + 1, j + 1, n, m)) {
                    int sum = matrix[i][j] + dp[i + 1][j - 1];
                    min = Math.min(sum, min);
                }
                dp[i][j] = min;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++)
            result = Math.min(result, dp[0][i]);
        return result;
    }

    public static void main(String[] args) {

    }

}
