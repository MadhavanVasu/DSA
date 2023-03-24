package LeetCode.Contest.Weekly333;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquareFreeSubset {

    public static int squareFreeSubsets(int[] nums) {
        Arrays.sort(nums);
        int prev = 0;
        List<Integer> prime = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
        {
            int flag = 0;
            if(i==0 || nums[i]!=nums[prev])
            {
                for(int j=2; j<=Math.floor(Math.sqrt(nums[i])); j++)
                {
                    if(nums[i]%j==0)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                    prime.add(nums[i]);
                prev = i;
            }
        }
        return (int)Math.pow(2,prime.size())-1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,4,5};
        System.out.println(squareFreeSubsets(nums));
    }

}
