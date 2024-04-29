package LeetCode.Medium;

public class MinimumNumberOfOperationsToSatisfyConditions {

    public int helper(int i, int j, Integer[][] dp, int[][] colValCount, int m) {
        if (i == m) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = 0; k <= 9; k++) {
            if (k != j) {
                int reqdOps = 0;
                for (int val = 0; val <= 9; val++) {
                    if (val != k) reqdOps += colValCount[i][val];
                }
                reqdOps += helper(i + 1, k, dp, colValCount, m);
                min = Math.min(min, reqdOps);
            }
        }
        dp[i][j] = min;
        return dp[i][j];
    }

    public int minimumOperations(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Integer[][] dp = new Integer[m][10];
        int[][] colValCount = new int[m][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                colValCount[j][grid[i][j]]++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 9; i++) {
            int res = helper(0, i, dp, colValCount, m);
            min = Math.min(res, min);
        }
        return min;
    }

    public static void main(String[] args) {

    }

}
