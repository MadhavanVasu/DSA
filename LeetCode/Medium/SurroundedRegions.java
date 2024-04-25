package LeetCode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    public boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                visited[i][0] = 1;
                queue.add(new int[]{i, 0});
            }
            if (board[i][m - 1] == 'O') {
                visited[i][m - 1] = 1;
                queue.add(new int[]{i, m - 1});
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                visited[0][i] = 1;
                queue.add(new int[]{0, i});
            }
            if (board[n - 1][i] == 'O') {
                visited[n - 1][i] = 1;
                queue.add(new int[]{n - 1, i});
            }
        }
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (isValid(x, y, n, m) && visited[x][y] == 0 && board[x][y] == 'O') {
                    visited[x][y] = 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {

    }

}
