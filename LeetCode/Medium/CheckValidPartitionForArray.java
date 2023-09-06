package LeetCode.Medium;

public class CheckValidPartitionForArray {

    public boolean helper(int i, int n, int[] nums, Boolean[] dp) {
        if (i >= n) return true;
        if (i == n - 1) return false;
        if (dp[i] != null) return dp[i];
        boolean a = false;
        boolean b = false;
        boolean c = false;
        if (i + 1 < n && nums[i] == nums[i + 1])
            a = helper(i + 2, n, nums, dp);
        if (i + 1 < n && i + 2 < n && nums[i] == nums[i + 1] && nums[i] == nums[i + 2])
            b = helper(i + 3, n, nums, dp);
        if (i + 1 < n && i + 2 < n && 1 + nums[i] == nums[i + 1] && 1 + nums[i + 1] == nums[i + 2])
            c = helper(i + 3, n, nums, dp);
        dp[i] = a || b || c;
        return dp[i];
    }

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return helper(0, n, nums, dp);
    }

    public static void main(String[] args) {

    }

}
