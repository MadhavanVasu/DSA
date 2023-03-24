package LeetCode.Medium;

public class LongIncSubseq {

    public static int helperFn(int i, int j, int[] nums, int[][] dp) {
        if (j != -1 && dp[i][j] != -1)
            return dp[i][j];
        int a = -1;
        int b = -1;
        int c = -1;
        if (j != -1 && nums[i] > nums[j]) {
            a = 1 + helperFn(i + 1, i, nums, dp);
        }
        b = helperFn(i+1,j,nums,dp);
        return 0;
    }

    public int lengthOfLIS(int[] nums) {
        return 0;
    }
}
