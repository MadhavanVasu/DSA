//package LeetCode.Medium;
//
//public class CombinationSum4 {
//
//    public int helper(int i, int target, int n, int[] nums, Integer[][] dp) {
//        if (i >= n) {
//            if (target == 0)
//                return 1;
//            else return 0;
//        }
//        if (target == 0) return 1;
//        if (dp[i][target] != null) return dp[i][target];
//
//        int a = 0;
//        int b = 0;
//
//        if (nums[i] <= target) {
//            a = helper(i, target - nums[i], n, nums, dp);
//            b = helper(i + 1, target, n, nums, dp);
//        }
//        dp[i][target] = a + b;
//        System.out.println(a + " " + b);
//        return dp[i][target];
//    }
//
//    public int combinationSum4(int[] nums, int target) {
//
//        int n = nums.length;
//        Integer[][] dp = new Integer[n][target + 1];
//        return helper(0, target, n, nums, dp);
//
//    }
//
//    public static void main(String[] args) {
//
//        int[] nums = {1, 2, 3};
//        int target = 4;
//        System.out.println(new CombinationSum4().combinationSum4(nums, target));
//
//    }
//
//}
