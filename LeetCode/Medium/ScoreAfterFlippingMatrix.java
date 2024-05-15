package LeetCode.Medium;

public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            boolean flag = grid[i][0] == 0;
            for (int j = 0; j < m; j++) {
                if (flag) result[i][j] = grid[i][j] == 0 ? 1 : 0;
                else result[i][j] = grid[i][j];
            }
        }
        int[] colCount = new int[m - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j != 0 && result[i][j] == 0) colCount[j - 1] += 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (colCount[i - 1] > (m - colCount[i - 1])) {
                    result[i][j] = result[i][j] == 1 ? 0 : 1;
                }
            }
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            int num = 0;
            int ele = 1;
            for (int j = m - 1; j >= 0; j--) {
                if (result[i][j] == 1) {
                    num += ele;
                }
                ele *= 2;
            }
            r += num;
        }
        return r;
    }

    public static void main(String[] args) {

    }

}
