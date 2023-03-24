package Medium;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<n/2; i++)
        {
            for(int j=i; j<m-i-1; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][m-j-1];
                matrix[n-i-1][m-j-1] = matrix[j][m-i-1];
                matrix[j][m-i-1] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2},{3,4}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

}
