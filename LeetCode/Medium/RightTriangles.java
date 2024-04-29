package LeetCode.Medium;

public class RightTriangles {

    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rowCount = new int[n];
        int[] colCount = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (rowCount[i] - 1 > 0 && colCount[j] - 1 > 0) {
                        result += ((long) (rowCount[i] - 1) * (colCount[j] - 1));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
