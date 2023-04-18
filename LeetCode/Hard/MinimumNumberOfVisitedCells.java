//package LeetCode.Hard;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class MinimumNumberOfVisitedCells {
//
//    public static int helper(int i, int j, int[][] grid, int[][] dp, int n, int m) {
//        if (i == n - 1 && j == m - 1) return 1;
//        if (grid[i][j] == 0) return Integer.MAX_VALUE;
//        if (dp[i][j] != -1) return dp[i][j];
//        int min = Integer.MAX_VALUE;
//        for (int ind = i + 1; ind <= Math.min(i + grid[i][j], n - 1); ind++) {
//            int ans = helper(ind, j, grid, dp, n, m);
//            if (ans != Integer.MAX_VALUE) min = Math.min(min, ans + 1);
//        }
//        for (int ind = j + 1; ind <= Math.min(j + grid[i][j], m - 1); ind++) {
//            int ans = helper(i, ind, grid, dp, n, m);
//            if (ans != Integer.MAX_VALUE) min = Math.min(min, ans + 1);
//        }
//        dp[i][j] = min;
//        return min;
//    }
//
//    public static int minimumVisitedCells(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        int[][] dp = new int[n][m];
//        for (int i = 0; i < n; i++)
//            for (int j = 0; j < m; j++)
//                dp[i][j] = -1;
//        int ans = helper(0, 0, grid, dp, n, m);
//        if (ans == Integer.MAX_VALUE) return -1;
//        return ans;
//    }
//
//
//    public static int minimumVisitedCellsBFS(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        Queue<List<Integer>> queue = new LinkedList<>();
//        int[][] visited = new int[n][m];
//        queue.add(new ArrayList<>(List.of(0, 0)));
//        visited[0][0] = 1;
//        int minCells = 0;
//        while (!queue.isEmpty()) {
//            int qSize = queue.size();
//            minCells++;
//            while (qSize-- > 0) {
//                List<Integer> index = queue.poll();
//                int i = index.get(0);
//                int j = index.get(1);
//                int k = grid[i][j];
//                if (i == n - 1 && j == m - 1) return minCells;
//                int ind = (j + k) >= m ? m - 1 : j + k;
//                for (; ind > j; ind--) {
//                    if (visited[i][ind] == 1) break;
//                    visited[i][ind] = 1;
//                    queue.add(List.of(i, ind));
//                }
//                ind = (i + k) >= n ? n - 1 : i + k;
//                for (; ind > i; ind--) {
//                    if (visited[ind][j] == 1) break;
//                    visited[ind][j] = 1;
//                    queue.add(List.of(ind, j));
//                }
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
////        int[][] grid = {{1}, {1}, {0}};
//        int[][] grid = {{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}, {2, 4, 0, 0}};
//        System.out.println(minimumVisitedCells(grid));
//    }
//
//}
