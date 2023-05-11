package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n / 2; i++) {
            if (visited[i][i] != 1) {
                for (int j = i; j < m - i; j++) {
                    result.add(matrix[i][j]);
                    visited[i][j] = 1;
                }
                for (int j = i + 1; j < n - i; j++) {
                    visited[j][m - i] = 1;
                    result.add(matrix[j][m - i]);
                }
                for (int j = m - i - 1; j >= i; j--) {
                    visited[m - i][j] = 1;
                    result.add(matrix[m - i][j]);
                }
                for (int j = n - i; j >= i; j--) {
                    visited[j][i] = 1;
                    result.add(matrix[j][i]);
                }

            }
        }
        return result;

    }

    public static void main(String[] args) {

    }

}
