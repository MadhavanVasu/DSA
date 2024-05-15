package LeetCode.Contest.Weekly373;

import java.util.Arrays;

public class MatrixSimilarityAfterCyclicShifts {

    public void reverse(int i, int j, int[] row) {
        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }

    public boolean helper(int[] row, int k) {
        int n = row.length;
        k = k % n;
        int[] shiftedRow = new int[n];
        for (int i = 0; i < row.length; i++)
            shiftedRow[i] = row[i];
        reverse(0, n - 1, shiftedRow);
        reverse(0, n - k - 1, shiftedRow);
        reverse(n - k, n - 1, shiftedRow);
        return Arrays.equals(row, shiftedRow);
    }

    public boolean areSimilar(int[][] mat, int k) {
        for (int[] row : mat) {
            boolean result = helper(row, k);
            if (!result) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(new MatrixSimilarityAfterCyclicShifts().areSimilar(new int[][]{{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}},
                2));

    }

}
