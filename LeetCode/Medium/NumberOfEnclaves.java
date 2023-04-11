package LeetCode.Medium;

public class NumberOfEnclaves {

    public void dfs(int i, int j, boolean[][] visited, int[][] grid, int n, int m) {
        if (i < n && j < m && i >= 0 && j >= 0 && grid[i][j] != 0 && !visited[i][j]) {
            visited[i][j] = true;
            dfs(i + 1, j, visited, grid, n, m);
            dfs(i, j + 1, visited, grid, n, m);
            dfs(i - 1, j, visited, grid, n, m);
            dfs(i, j - 1, visited, grid, n, m);
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !visited[i][0])
                dfs(i, 0, visited, grid, n, m);
            if (grid[i][m - 1] == 1 && !visited[i][m - 1])
                dfs(i, m - 1, visited, grid, n, m);
        }
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1 && !visited[0][i])
                dfs(0, i, visited, grid, n, m);
            if (grid[n - 1][i] == 1 && !visited[n - 1][i])
                dfs(n - 1, i, visited, grid, n, m);
        }
        int result = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!visited[i][j] && grid[i][j] == 1)
                    result++;
        return result;
    }

}
