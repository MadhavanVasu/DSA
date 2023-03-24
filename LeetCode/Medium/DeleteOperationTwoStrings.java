package LeetCode.Medium;

public class DeleteOperationTwoStrings {

    public static int helper(int i, int j, int n, int m, String word1, String word2, int[][] dp) {
        if (i >= n)
            return m - j;
        if (j >= m)
            return n - i;
        if (dp[i][j] != -1)
            return dp[i][j];
        int a = Integer.MAX_VALUE;
        if (word1.charAt(i) == word2.charAt(j))
            a = helper(i + 1, j + 1, n, m, word1, word2, dp);
        int b = 1 + helper(i + 1, j, n, m, word1, word2, dp);
        int c = 1 + helper(i, j + 1, n, m, word1, word2, dp);
        dp[i][j] = Math.min(Math.min(a, b), c);
        return dp[i][j];
    }

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                dp[i][j] = -1;
        }
        return helper(0, 0, n, m, word1, word2, dp);

    }

    public static void main(String[] args) {

        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1, word2));

    }

}
