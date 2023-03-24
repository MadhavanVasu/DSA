package LeetCode.Medium;

import java.util.*;

public class ThreeSum3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n-2; i++)
        {
            int start = i+1;
            int end = n-1;
            while(start<end)
            {
                int sum = nums[i]+nums[start]+nums[end];
                if(sum==0) {
                    result.add(new ArrayList<>(List.of(nums[i], nums[start], nums[end])));
                    start++;
                    end--;
                }
                else if(sum>0)
                    end--;
                else
                    start++;
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {

    }

}
