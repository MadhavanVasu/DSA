//package LeetCode.Medium;
//
//public class NumberOfIslands {
//
//    public boolean isValid(int i, int j, int n, int m) {
//        return i >= 0 && i < n && j >= 0 && j < m;
//    }
//
//    public int numIslands(char[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        boolean[][] visited = new boolean[n][m];
//        int result = 0;
//        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j] == '1' && !visited[i][j]) {
//                    result++;
//                    Queue<int[]> q = new LinkedList<>();
//                    q.add(new int[]{i, j});
//                    while (!q.isEmpty()) {
//                        int[] index = q.poll();
//                        for (int[] direction : directions) {
//                            int x = index[0] + direction[0];
//                            int y = index[1] + direction[1];
//                            if (isValid(x, y, n, m) && !visited[x][y] && grid[x][y] == '1') {
//                                visited[x][y] = true;
//                                q.add(new int[]{x, y});
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
