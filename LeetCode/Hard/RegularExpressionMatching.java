package LeetCode.Hard;

public class RegularExpressionMatching {

    public boolean helper(int i, int j, String s, String p, Boolean[][] dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;
        if (i < 0) {
            while (j >= 0) {
                if ((p.charAt(j) == '*') || (j + 1 < p.length() && p.charAt(j + 1) == '*')) j--;
                else return false;
            }
            return true;
        }
        if (dp[i][j] != null) return dp[i][j];
        int dupJ = j;
        switch (p.charAt(j)) {
            case '*':
                while (p.charAt(j) == '*') j--;
                char c = p.charAt(j);
                dp[i][dupJ] = helper(i, j - 1, s, p, dp);
                if (!dp[i][dupJ]) {
                    int ind = i;
                    while (ind >= 0 && (s.charAt(ind) == c || c == '.')) {
                        dp[i][dupJ] = helper(ind - 1, j - 1, s, p, dp);
                        if (dp[i][dupJ])
                            return true;
                        ind--;
                    }
                }
                break;
            case '.':
                dp[i][j] = helper(i - 1, j - 1, s, p, dp);
                return dp[i][j];
            default:
                if (s.charAt(i) == p.charAt(j)) {
                    dp[i][j] = helper(i - 1, j - 1, s, p, dp);
                    return dp[i][j];
                }
        }
        return dp[i][dupJ];
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return helper(n - 1, m - 1, s, p, new Boolean[n][m]);
    }

    public static void main(String[] args) {

    }

}
