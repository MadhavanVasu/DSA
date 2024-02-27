package LeetCode.Hard;

public class CherryPickup2 {

    public boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public int helper(int x1, int y1, int x2, int y2, int[][] grid, int n, int m, Integer[][][][] dp) {
        if (x1 == n && x2 == n) {
            if (y1 == y2) return grid[x1][y1];
            return grid[x1][y1] + grid[x2][y2];
        }
        if (dp[x1][y1][x2][y2] != null) return dp[x1][y1][x2][y2];
        int[][] directions = new int[][]{{1, -1}, {1, 0}, {1, 1}};
        int sum;
        if (y1 == y2) sum = grid[x1][y1];
        else sum = grid[x1][y1] + grid[x2][y2];
        int max = 0;
        for (int[] direction : directions) {
            int newX1 = x1 + direction[0];
            int newY1 = y1 + direction[1];
            for (int[] dir : directions) {
                int newX2 = x2 + dir[0];
                int newY2 = y2 + dir[1];
                if (isValid(newX1, newY1, n, m) && isValid(newX2, newY2, n, m)) {
                    int currMax = sum + helper(newX1, newY1, newX2, newY2, grid, n, m, dp);
                    if (currMax > max) max = currMax;
                }
            }
        }
        dp[x1][y1][x2][y2] = max;
        return max;
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Integer[][][][] dp = new Integer[n][m][n][m];
        return helper(0, 0, 0, m - 1, grid, n, m, dp);
    }

    public static void main(String[] args) {

    }

}
