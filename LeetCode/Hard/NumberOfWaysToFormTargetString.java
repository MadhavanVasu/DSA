package LeetCode.Hard;


public class NumberOfWaysToFormTargetString {

    public static int helper(int i, int j, int[][] charFreq, int n, int m, String target, int[][] dp) {
        if (j == m)
            return 1;
        if (i >= n)
            return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int a = 0;
        if (charFreq[i][target.charAt(j) - 'a'] != 0) {
            a = (int) (((long) charFreq[i][target.charAt(j) - 'a'] * helper(i + 1, j + 1, charFreq, n, m, target, dp)) % 1000000007);
        }
        int b = (int) (((long) helper(i + 1, j, charFreq, n, m, target, dp)) % 1000000007);
        dp[i][j] = (a + b) % 1000000007;
        return dp[i][j];
    }

    public static int numWays(String[] words, String target) {
        int m = words[0].length();
        if (m < target.length()) return 0;
        int[][] charFreq = new int[m][26];
        for (String x : words) {
            for (int i = 0; i < m; i++) {
                charFreq[i][x.charAt(i) - 'a'] += 1;
            }
        }
        int[][] dp = new int[m][target.length()];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < target.length(); j++)
                dp[i][j] = -1;
        return helper(0, 0, charFreq, m, target.length(), target, dp);
    }

    public static void main(String[] args) {

        String[] words = {"acca", "bbbb", "caca"};
        String target = "aba";
        System.out.println(numWays(words, target));

    }

}
