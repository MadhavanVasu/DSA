package LeetCode.Medium;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1)
            return true;
        int pos = n-1;
        boolean result = false;
        for(int i=n-2; i>=0; i--)
        {
            if(i+nums[i]>=pos)
            {
                result = true;
                pos = i;
            }
            else
                result = false;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

}
