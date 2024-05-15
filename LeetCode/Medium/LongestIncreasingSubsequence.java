package LeetCode.Medium;

public class LongestIncreasingSubsequence {

    public int helper(int i, int j, int[] nums, Integer[][] dp, int n) {
        if (i >= n || j >= n) return 0;
        if (j != -1 && dp[i][j] != null) return dp[i][j];
        if (j == -1 && dp[i][i] != null) return dp[i][j];
        int a = 0;
        if (j == -1 || nums[i] > nums[j]) a = 1 + helper(i + 1, i, nums, dp, n);
        int b = helper(i + 1, j, nums, dp, n);
        if (j == -1) j = i;
        dp[i][j] = Math.max(a, b);
        return dp[i][j];
    }


    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        return helper(0, -1, nums, dp, n);
    }


//    public static int helper(int i, int prev, int[] nums , int n, int[][] dp)
//    {
//        if(i>=n)
//            return 0;
//        if(prev!=-1 && nums[i]>nums[prev])
//            return dp[i][i];
//        if(prev!=-1 && nums[i]<=nums[prev] && dp[i][prev]!=-1)
//            return dp[i][prev];
//        if(prev==-1 && dp[i][i]!=-1)
//            return dp[i][i];
//
//        int a = 0;
//        int b = 0;
//        if(prev==-1 || nums[i]>nums[prev]) {
//            a = 1 + helper(i + 1, i, nums, n, dp);
//            b = helper(i + 1, prev, nums, n, dp);
//        }
//        if(prev==-1)
//            prev = i;
//        dp[i][prev] = Math.max(a,b);
//        return dp[i][prev];
//    }
//
//    public static int lengthOfLIS(int[] nums) {
//
//        int n = nums.length;
//        int[][] dp = new int[n][n];
//        for(int i=0; i<n; i++)
//        {
//            for(int j=0; j<n; j++)
//                dp[i][j] = -1;
//
//        }
//        helper(0,-1, nums, n, dp);
//        int max = -1;
//        System.out.println(Arrays.deepToString(dp));
//        for(int i=0; i<n; i++)
//        {
//            for (int j=0; j<n; j++)
//            {
//                if(max<dp[i][j])
//                    max = dp[i][j];
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));

    }

}
