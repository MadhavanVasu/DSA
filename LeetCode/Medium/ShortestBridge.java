//package LeetCode.Medium;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class ShortestBridge {
//
//    public int shortestBridge(int[][] grid) {
//
//        Queue<List<Integer>> queue = new LinkedList<>();
//        int n = grid.length;
//        int m = grid.length;
//        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//        while (!queue.isEmpty()) {
//            List<Integer> vertex = queue.poll();
//            int x = vertex.get(0);
//            int y = vertex.get(1);
//            grid[x][y] = 2;
//            for (int[] direction : directions) {
//                int i = x + direction[0];
//                int j = y + direction[1];
//                if (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1) {
//                    grid[i][j] = 2;
//                    queue.add(new ArrayList<>(List.of(i, j)));
//                }
//            }
//        }
//        int[][] visited = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j] == 1 && visited[i][j] != 1) {
//                    int level = 0;
//                    queue.add(new ArrayList<>(List.of(i, j)));
//                    while (!queue.isEmpty()) {
//                        int qSize = queue.size();
//                        level++;
//                        while (qSize--!=0)
//                        {
//                            List<Integer> vertex = queue.poll();
//                            int x = vertex.get(0);
//                            int y = vertex.get(1);
//                            grid[x][y] = 2;
//                            for (int[] direction : directions) {
//                                int i = ;
//                                int j = ;
//                                if (x + direction[0] >= 0 && x + direction[0] < n && y + direction[1] >= 0 && y + direction[1] < m && grid[x + direction[0]][y + direction[1]] == 0) {
//                                    grid[i][j] = 2;
//                                    queue.add(new ArrayList<>(List.of(i, j)));
//                                }
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
