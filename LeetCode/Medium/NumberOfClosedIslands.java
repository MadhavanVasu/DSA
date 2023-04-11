package LeetCode.Medium;

public class NumberOfClosedIslands {

    public static int dfs(int i, int j, int[][] grid, int n, int m, int[][] visited) {
        if (i >= n || j >= m || i < 0 || j < 0)
            return 0;
        if (visited[i][j] != -1) return visited[i][j];
        if (grid[i][j] == 1) return 1;
        visited[i][j] = 1;
        int a = dfs(i + 1, j, grid, n, m, visited);
        int b = dfs(i, j + 1, grid, n, m, visited);
        int c = dfs(i - 1, j, grid, n, m, visited);
        int d = dfs(i, j - 1, grid, n, m, visited);
        visited[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
        return visited[i][j];
    }

    public static int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = -1;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == -1 && grid[i][j] != 1)
                    result += dfs(i, j, grid, n, m, visited);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1}};
        System.out.println(closedIsland(grid));

    }

}
