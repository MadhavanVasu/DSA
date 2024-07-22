package LeetCode.Medium;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindTheSafestPathInAGrid {

    public boolean isValid(int i, int j, int n, int[][] visited) {
        return i >= 0 && i < n && j >= 0 && j < n && visited[i][j] != 1;
    }

    public int findMaxPossiblePath(int[][] minDist, int n) {
        Queue<int[]> queue = new LinkedList<>();
        Integer[][] safeDist = new Integer[n][n];
        queue.add(new int[]{0, 0});
        int[][] visited = new int[n][n];
        safeDist[0][0] = minDist[0][0];
        visited[0][0] = 1;
        int[][] directions = new int[][]{{1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] ind = queue.poll();
            int i = ind[0];
            int j = ind[1];
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (safeDist[x][y] == null) {
                        safeDist[x][y] = Math.min(minDist[x][y], safeDist[x][y]);
                    } else {
                        if (safeDist[i][j] > safeDist[x][y] && safeDist[i][j] <= minDist[x][y])
                            safeDist[x][y] = safeDist[i][j];
                    }
                    if (visited[x][y] != 1) {
                        visited[x][y] = 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return safeDist[n - 1][n - 1];
    }

    public int findShortestPath(int[][] minDist, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.add(new int[]{minDist[0][0], 0, 0});
        int[][] visited = new int[n][n];
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Integer[][] safeDist = new Integer[n][n];
        visited[0][0] = 1;
        while (!pq.isEmpty()) {
            int[] ele = pq.poll();
            int safe = ele[0];
            int i = ele[1];
            int j = ele[2];
            if (i == n - 1 && j == n - 1) return safe;
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (isValid(x, y, n, visited)) {
                    visited[x][y] = 1;
                    int s = Math.min(safe, minDist[x][y]);
                    pq.add(new int[]{s, x, y});
                }
            }
        }
        return 0;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] minDist = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    minDist[i][j] = 0;
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] ind = queue.poll();
            int i = ind[0];
            int j = ind[1];
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (isValid(x, y, n, visited)) {
                    visited[x][y] = 1;
                    minDist[x][y] = minDist[i][j] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return findShortestPath(minDist, n);
    }

    public static void main(String[] args) {

    }

}
