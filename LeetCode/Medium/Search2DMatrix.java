package LeetCode.Medium;

public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                start = mid + 1;
            else
                end = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix,target));
    }

}
