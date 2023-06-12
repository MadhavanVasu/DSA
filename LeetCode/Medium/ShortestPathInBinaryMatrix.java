package LeetCode.Medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<List<Integer>> queue = new LinkedList<>();
        int level = 0;
        queue.add(List.of(0, 0));
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            level++;
            while (qSize-- != 0) {
                List<Integer> vertex = queue.poll();
                int x = vertex.get(0);
                int y = vertex.get(1);
                if (x == n - 1 && y == m - 1) return level;
                for (int[] direction : directions) {
                    if (x + direction[0] >= 0 && x + direction[0] < n && y + direction[1] >= 0 && y + direction[1] < m
                            && grid[x + direction[0]][y + direction[1]] == 0
                            && visited[x + direction[0]][y + direction[1]] != 1) {
                        visited[x + direction[0]][y + direction[1]] = 1;
                        queue.add(List.of(x + direction[0], y + direction[1]));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
