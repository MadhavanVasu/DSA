package LeetCode.Medium;

public class WordSearch {

    public boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public boolean helper(int i, int j, int k, char[][] board, String word, Boolean[][][] dp, int n, int m, int len, int[][] visited) {
        if (k >= len) return true;
        if (!isValid(i, j, n, m) || visited[i][j] == 1) return false;
        visited[i][j] = 1;
        if (dp[i][j][k] != null) return dp[i][j][k];
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        if (board[i][j] == word.charAt(k)) {
            for (int[] direction : directions) {
                boolean a = helper(i + direction[0], j + direction[1], k + 1, board, word, dp, n, m, len, visited);
                if (a) {
                    dp[i][j][k] = true;
                    return true;
                }
            }
        }
        dp[i][j][k] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int len = word.length();
        Boolean[][][] dp = new Boolean[n][m][len];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[][] visited = new int[n][m];
                boolean result = helper(i, j, 0, board, word, dp, n, m, len, visited);
                if (result) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
