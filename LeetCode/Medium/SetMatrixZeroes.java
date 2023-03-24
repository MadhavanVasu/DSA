package Medium;

import java.util.Arrays;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(matrix[i][j]==0) {
                    if(i==0)
                        row = 1;

                    if(j==0)
                        col = 1;

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;

                }
            }
        }
        for (int i=1 ;i<n; i++)
        {
            for (int j=1; j<m; j++)
            {
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j] = 0;
            }
        }
        if(row==1)
        {
            for (int i=0 ;i<m; i++)
                matrix[0][i] = 0;
        }
        if(col==1)
        {
            for (int i=0 ;i<n; i++)
                matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        
    }
    
}
