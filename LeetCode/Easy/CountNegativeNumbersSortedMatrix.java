package LeetCode.Easy;

public class CountNegativeNumbersSortedMatrix {

    public int countNegatives(int[][] grid) {

        int result = 0;
        for (int[] arr : grid) {
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] < 0) end = mid - 1;
                else start = mid + 1;
            }
            result += (arr.length - start);
        }
        return result;

    }

    public static void main(String[] args) {

    }

}
