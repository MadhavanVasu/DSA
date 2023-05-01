package LeetCode.Medium;

import java.util.Arrays;

public class FirstCompletelyPaintedIndex {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int total = n * m;
        int[][] elementIndex = new int[total + 1][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                elementIndex[mat[i][j]] = new int[]{i, j};
        int[] rowsPainted = new int[n];
        int[] colsPainted = new int[m];
        for (int i = 0; i < total; i++) {
            rowsPainted[elementIndex[arr[i]][0]]++;
            colsPainted[elementIndex[arr[i]][1]]++;
            if (rowsPainted[elementIndex[arr[i]][0]] == m || colsPainted[elementIndex[arr[i]][1]] == n) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 5, 2, 6, 3};
        int[][] mat = {{4, 3, 5}, {1, 2, 6}};
        System.out.println(new FirstCompletelyPaintedIndex().firstCompleteIndex(arr, mat));

    }

}
