package LeetCode.Contest.Weekly387;

public class CountSubmatricesWithTopLeftSumLessThanK {

    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] prefixSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            int pfSum = 0;
            for (int j = 0; j < m; j++) {
                pfSum += grid[i][j];
                prefixSum[i][j] = pfSum;
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += prefixSum[j][i];
                if (sum > k) break;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
