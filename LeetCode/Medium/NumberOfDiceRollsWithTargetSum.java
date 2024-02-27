package LeetCode.Medium;

public class NumberOfDiceRollsWithTargetSum {
    int MOD = 1000000007;

    public int helper(int i, int k, int n, int target, Integer[][] dp) {
        if (i >= n) {
            if (target == 0) return 1;
            return 0;
        }
        if (target == 0) return 0;
        if (dp[i][target] != null) return dp[i][target];
        int ans = 0;
        for (int j = 1; j <= k; j++) {
            if (j > target) break;
            ans = (ans + helper(i + 1, k, n, target - k, dp)) % MOD;
        }
        dp[i][target] = ans;
        return ans;
    }

    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n][target + 1];
        return helper(0, k, n, target, dp);
    }

    public static void main(String[] args) {

    }

}
