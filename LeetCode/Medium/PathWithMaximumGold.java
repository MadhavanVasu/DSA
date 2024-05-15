package LeetCode.Medium;

public class PathWithMaximumGold {

    public boolean isValid(int i, int j, int n, int m, int[][] grid, int[][] visited) {
        return i < n && i >= 0 && j < m && j >= 0 && grid[i][j] != 0 && visited[i][j] != 1;
    }

    public int helper(int i, int j, int[][] grid, int n, int m, int[][] visited) {
        visited[i][j] = 1;
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int max = grid[i][j];
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (isValid(x, y, n, m, grid, visited)) {
                int val = grid[i][j] + helper(x, y, grid, n, m, visited);
                max = Math.max(max, val);
            }
        }
        visited[i][j] = 0;
        return max;
    }

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, helper(i, j, grid, n, m, new int[n][m]));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
