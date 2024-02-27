package LeetCode.Medium;

public class DecodeWays {

    public int helper(int i, String s, Integer[] dp, int n) {
        if (i >= n) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != null) return dp[i];
        int ans = 0;
        ans += helper(i + 1, s, dp, n);
        if (i + 1 < n) {
            int dig = s.charAt(i + 1) - '1' + 1;
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && dig <= 6)) {
                ans += helper(i + 2, s, dp, n);
            }
        }
        dp[i] = ans;
        return ans;
    }

    public int numDecodings(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n];
        return helper(0, s, dp, n);
    }

    public static void main(String[] args) {

    }

}
