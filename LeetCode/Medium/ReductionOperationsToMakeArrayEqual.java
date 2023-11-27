package LeetCode.Medium;

import java.util.Arrays;

public class ReductionOperationsToMakeArrayEqual {

    public int reductionOperationsOptimal(int[] nums) {
        int max = 0;
        for (int x : nums) {
            if (x > max) max = x;
        }
        int[] countArr = new int[max + 1];
        for (int x : nums) countArr[x]++;
        int count = countArr[max];
        int result = 0;
        for (int i = max - 1; i >= 0; i--) {
            if (countArr[i] != 0) {
                result += count;
                count += countArr[i];
            }
        }
        return result;
    }

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int prev = nums[n - 1];
        int count = 1;
        int result = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == prev) {
                count++;
            } else {
                result = count;
                prev = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
