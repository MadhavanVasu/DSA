package LeetCode.Hard;

public class RestoreTheArray {

    public int helper(int i, String s, int k, int n, int[] dp) {
        if (i == n)
            return 1;
        if (dp[i] != -1) return dp[i];
        int ans = 0;
        long num = 0;
        for (int pos = i; pos < n; pos++) {
            num = (num * 10) + Integer.parseInt(String.valueOf(s.charAt(pos)));
            if (num > 0 && num <= k) {
                int possibilities = helper(pos + 1, s, k, n, dp) % 1000000007;
                ans = (ans + possibilities) % 1000000007;
            } else break;
        }
        dp[i] = ans % 1000000007;
        return ans;
    }

    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = -1;
        return helper(0, s, k, n, dp);
    }

    public static void main(String[] args) {

    }

}
