package Medium;

public class KadanesAlgorithm {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        int n = nums.length;
        for(int i=1; i<n;i++)
        {
            sum+=nums[i];
            if(nums[i]>sum)
                sum=nums[i];
            if(max<sum)
                max=sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,100,-1,100,-100};
        System.out.println(maxSubArray(nums));

    }
}
