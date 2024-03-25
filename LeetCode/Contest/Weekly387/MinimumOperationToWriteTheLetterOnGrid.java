package LeetCode.Contest.Weekly387;

import java.util.Arrays;

public class MinimumOperationToWriteTheLetterOnGrid {

    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int[] yCount = new int[3];
        int yElementCount = 0;
        int[] notYCount = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j && i <= n / 2) || (j > i && j == n - i - 1 && i <= n / 2) || (i > n / 2 && j == n / 2)) {
                    yCount[grid[i][j]]++;
                    yElementCount++;
                } else notYCount[grid[i][j]]++;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    int toBeChanged = yElementCount - yCount[i];
                    toBeChanged += ((n * n) - yElementCount) - notYCount[j];
                    result = Math.min(toBeChanged, result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumOperationToWriteTheLetterOnGrid().minimumOperationsToWriteY(new int[][]{{0, 1, 0, 1, 0}, {2, 1, 0, 1, 2}, {2, 2, 2, 0, 1}, {2, 2, 2, 2, 2}, {2, 1, 2, 2, 2}}
        ));
    }

}
