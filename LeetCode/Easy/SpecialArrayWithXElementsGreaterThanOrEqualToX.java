package LeetCode.Easy;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualToX {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= result && (i - 1 >= 0 && nums[i - 1] < result)) return result;
            result--;
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
