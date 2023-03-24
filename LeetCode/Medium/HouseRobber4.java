package LeetCode.Medium;

// https://leetcode.com/problems/house-robber-iv/

import java.util.Arrays;

public class HouseRobber4 {

    public static int minCapability(int[] nums, int k) {
        int left = Arrays.stream(nums).min().orElse(1);
        int right = Arrays.stream(nums).max().orElse((int)1e9);
        int n = nums.length;
        while (left<right)
        {
            int mid = left + (right-left)/2;
            int housesRobbed = 0;
            for(int i=0; i<n; i++)
            {
                if(nums[i]<=mid) {
                    housesRobbed++;
                    i++;
                }
            }
            if(housesRobbed>=k)
                right = mid;
            else
                left = mid+1;
        }
        return left;

    }

    public static void main(String[] args) {

        int[] nums = {2,7,9,3,1};
        System.out.println(minCapability(nums, 2));

    }

}
