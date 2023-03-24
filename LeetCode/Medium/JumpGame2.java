package LeetCode.Medium;

public class JumpGame2 {

    public static double helperFn(int i, int[] nums, double[] dp, int n)
    {
        if(i==n-1)
            return 0;
        if(nums[i]==0)
            return Double.POSITIVE_INFINITY;
        if(dp[i]!=-1)
            return dp[i];
        double min = Double.POSITIVE_INFINITY;
        for(int j = 1; j<nums[i]+1; j++)
        {
            double temp = 1 + helperFn(i+j,nums,dp,n);
            if(temp<min)
                min = temp;
        }
        dp[i] = min;
        return dp[i];
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        double[] dp = new double[n];
        for(int i=0; i<n; i++)
            dp[i] = -1;
        return (int) helperFn(0,nums,dp,n);
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

}
