package LeetCode.Contest.Weekly348;

public class SumOfMatrixAfterQueries {

    public long matrixSumQueries(int n, int[][] queries) {

        long sum = 0;
        int[] rows = new int[n];
        int[] cols = new int[n];
        for (int i = 0; i < n; i++) {
            rows[i] = -1;
            cols[i] = -1;
        }
        int rowCount = n;
        int colCount = n;
        int m = queries.length;
        for (int i = m - 1; i >= 0; i--) {
            if (queries[i][0] == 0) {
                if (rows[queries[i][1]] == -1) {
                    sum += ((long) colCount * queries[i][2]);
                    rowCount--;
                    rows[queries[i][1]] = 1;
                }
            } else {
                if (cols[queries[i][1]] == -1) {
                    sum += ((long) rowCount * queries[i][2]);
                    colCount--;
                    cols[queries[i][1]] = 1;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
