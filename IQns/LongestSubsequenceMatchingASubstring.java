//package IQns;
//
//public class LongestSubsequenceMatchingASubstring {
//
//    // "azecde"
//    // "abcde"
//
//    public int helper(int i, int j, String x, String y, int n, int m, Integer[][] dp) {
//        if (i >= n || j >= m) return 0;
//        if (dp[i][j] != null) return dp[i][j];
//        int a = 0;
//        int b = 0;
//        int c = 0;
//        if (x.charAt(i) == y.charAt(j)) a = 1 + helper(i + 1, j + 1, x, y, n, m, dp);
//        b = helper(i, j + 1, x, y, n, m);
//
//    }
//
//
//}
