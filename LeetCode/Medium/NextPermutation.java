package Medium;

import java.util.Arrays;

public class NextPermutation {
    public static void reverse(int[] nums, int start, int end) {
        int length = end - start + 1;
        for (int i = 0; i < length / 2; i++) {
            int j = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = j;
        }

    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        while (i > 0) {
            if (nums[i] <= nums[i - 1])
                i--;
            else
                break;
        }
        int pos = i - 1;
        if (i != 0) {
            while (i < n) {
                if (nums[pos] >= nums[i])
                    break;
                i++;
            }
            int temp = nums[pos];
            nums[pos] = nums[i - 1];
            nums[i - 1] = temp;
        }
        reverse(nums,pos+1,n-1);

    }

    public static void main(String[] args) {

        int[] nums = {1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
