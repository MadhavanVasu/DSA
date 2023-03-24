package LeetCode.Easy;

public class LeftRightDifference {

    public static int[] leftRigthDifference(int[] nums) {

        int n = nums.length;
        int[] prefixArray = new int[n];
        int[] suffixArray = new int[n];
        prefixArray[0] = 0;
        suffixArray[n-1] = 0;
        for(int i=1;i<n;i++) prefixArray[i] = prefixArray[i-1] + nums[i-1];
        for(int i=n-2;i>=0;i--) suffixArray[i] = suffixArray[i+1] + nums[i+1];
        int[] result = new int[n];
        for(int i=0; i<n; i++) result[i] = Math.abs(prefixArray[i]-suffixArray[i]);
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {10,4,8,3};
        System.out.println(leftRigthDifference(nums));
    }

}
