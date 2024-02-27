package LeetCode.Contest.Weekly384;

public class ModifyTheMatrix {

    public int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] colMax = new int[m];
        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] > max && matrix[j][i] != -1) max = matrix[j][i];
            }
            colMax[i] = max;
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) result[i][j] = colMax[j];
                else result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
