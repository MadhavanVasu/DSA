package LeetCode.Easy;

public class LargestLocalValuesInAMatrix {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int max = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++)
                        max = Math.max(grid[x][y], max);
                }
                result[i - 1][j - 1] = max;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
