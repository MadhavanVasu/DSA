package LeetCode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Integer[]> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Integer[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int level = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- != 0) {
                Integer[] node = queue.poll();
                int i = node[0];
                int j = node[1];
                result[i][j] = level;
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (isValid(x, y, n, m) && visited[x][y] == 0) {
                        visited[x][y] = 1;
                        queue.add(new Integer[]{x, y});
                    }
                }
            }
            level++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
