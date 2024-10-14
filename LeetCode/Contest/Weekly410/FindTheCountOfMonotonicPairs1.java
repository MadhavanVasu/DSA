package LeetCode.Contest.Weekly410;

public class FindTheCountOfMonotonicPairs1 {

    int MOD = 1000000007;

    public int helper(int i, int prev, int[] nums, int n, Integer[][] dp) {
        if (i == n) return 1;
        if (dp[i][prev] != null) return dp[i][prev];
        int totalPossible = 0;
        int j = -1;
        if (i - 1 < 0) j = prev;
        else {
            int start = prev;
            int end = nums[i];
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int k = nums[i] - mid;
                if ((nums[i - 1] - prev) >= k) {
                    j = mid;
                    end = mid - 1;
                } else start = mid + 1;
            }
        }
        if (j > -1) {
            for (; j <= nums[i]; j++) {
                totalPossible = (totalPossible + helper(i + 1, j, nums, n, dp)) % MOD;
            }
        }
        dp[i][prev] = totalPossible;
        return totalPossible;
    }

    public int countOfPairs(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][51];
        int result = 0;
        result = (result + helper(0, 0, nums, n, dp)) % MOD;
        return result;
    }

    public static void main(String[] args) {

    }

}
