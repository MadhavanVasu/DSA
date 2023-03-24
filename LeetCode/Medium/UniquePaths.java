package LeetCode.Medium;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++)
            paths[i][n - 1] = 1;
        for (int i = 0; i < n; i++)
            paths[m - 1][i] = 1;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--)
                paths[i][j] = paths[i][j + 1] + paths[i + 1][j];
        }
        return paths[0][0];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m,n));
    }

}
