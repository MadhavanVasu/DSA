package LeetCode.Contest.Weekly353;

public class MaximumNumberOfJumps {

    public int helper(int i, int[][] dp, int[] nums, int target, int n, int prev) {
        if (i >= n) {
            if (prev != n - 1) return -1;
            return 1;
        }
        if (dp[i][prev] != 0) return dp[i][prev];
        int res;
        if (i != 0) {
            long diff = (long) nums[i] - nums[prev];
            int a = -1;
            int b = -1;
            if (diff >= -target && diff <= target) {
                a = helper(i + 1, dp, nums, target, n, i);
            }
            if (a != -1)
                a += 1;
            b = helper(i + 1, dp, nums, target, n, prev);
            res = Math.max(a, b);
        } else {
            res = helper(i + 1, dp, nums, target, n, i);
        }
        dp[i][prev] = res;
        return res;
    }

    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;
        int[][] dp = new int[n][n];
        int ans = helper(0, dp, nums, target, n, 0);
        if (ans == -1) return ans;
        else return ans - 1;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 3, 6, 4, 1, 2};
//        int[] nums = {1, 3, 4};
//        int target = 0;
//        int target = 3;

        int[] nums = {1, 0, 2};
        int target = 1;
        System.out.println(new MaximumNumberOfJumps().maximumJumps(nums, target));

    }

}
