package LeetCode.Medium;

public class Search2DMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++)
        {
            if(target>=matrix[i][0] && target<=matrix[0][n-1])
            {
                int start = 0;
                int end = n-1;
                while(start<=end)
                {
                    int mid = (start+end)/2;
                    if(matrix[i][mid]==target)
                        return true;
                    else if(matrix[i][mid]>target)
                        end = mid-1;
                    else
                        start = mid+1;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {

    }

}
