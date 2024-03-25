package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while (i < n) {
            while (nums[i] != 0 && nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    result.add(nums[i]);
                    nums[i] = 0;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
