package LeetCode.Medium;

import java.util.Arrays;

public class FindMaxMarkedindices {

    public static int maxNumOfMarkedIndices(int[] nums) {

        Arrays.sort(nums);
        int result = 0;
        int n = nums.length;
        int i = 0;
        int j = n / 2;
        if (n % 2 != 0)
            j++;
        while (i < n / 2 && j < n) {
            if (2 * nums[i] <= nums[j]) {
                result += 2;
                i++;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {9, 2, 5, 4};
        System.out.println(maxNumOfMarkedIndices(nums));

    }

}
