package LeetCode.Medium;


public class LongestCommonSubseq {

    public static int helperFn(int i, int j, String text1, String text2, int[][] dp, int n, int m) {
        if (i >= n || j >= m)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int a = -1, b = -1, c = -1;
        if (text1.charAt(i) == text2.charAt(j)) {
            a = 1 + helperFn(i + 1, j + 1, text1, text2, dp, n, m);
        } else {
            b = helperFn(i + 1, j, text1, text2, dp, n, m);
            c = helperFn(i, j + 1, text1, text2, dp, n, m);
        }
        dp[i][j] = Math.max(Math.max(a, b), c);
        return dp[i][j];
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                dp[i][j] = -1;
        }
        return helperFn(0, 0, text1, text2, dp, n, m);
    }

    public static void main(String[] args) {

        String text1 = "bl";
        String text2 = "yby";

        System.out.println(longestCommonSubsequence(text1, text2));

    }


}
