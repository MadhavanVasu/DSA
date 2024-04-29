package LeetCode.Medium;

public class MinimumFallingPathSum2 {

    public int[] findFirstAndSecondMinimum(int[] row, int n) {
        int firstMinInd = -1;
        int secondMinInd = -1;
        for (int i = 0; i < n; i++) {
            if (firstMinInd == -1) {
                firstMinInd = i;
            } else if (row[i] < row[firstMinInd]) {
                secondMinInd = firstMinInd;
                firstMinInd = i;
            } else if (secondMinInd == -1 || row[i] < row[secondMinInd]) {
                secondMinInd = i;
            }
        }
        return new int[]{firstMinInd, secondMinInd};
    }

    public int minFallingPathSumOptimal(int[][] grid) {
        int n = grid.length;
        int[] minIndices = findFirstAndSecondMinimum(grid[n - 1], n);
        int firstMinInd = minIndices[0];
        int secondMinInd = minIndices[1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (firstMinInd == j) {
                    grid[i][j] += grid[i + 1][secondMinInd];
                } else grid[i][j] += grid[i + 1][firstMinInd];
            }
            minIndices = findFirstAndSecondMinimum(grid[i], n);
            firstMinInd = minIndices[0];
            secondMinInd = minIndices[1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) min = Math.min(grid[0][i], min);
        return min;
    }

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] dp = new int[n];
        System.arraycopy(grid[n - 1], 0, dp, 0, n);
        for (int i = n - 2; i >= 0; i--) {
            int[] tempDp = new int[n];
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j && min > dp[k]) {
                        min = dp[k];
                    }
                }
                tempDp[j] = min + grid[i][j];
            }
            System.arraycopy(tempDp, 0, dp, 0, n);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) min = Math.min(dp[i], min);
        return min;
    }

    public static void main(String[] args) {

    }

}
