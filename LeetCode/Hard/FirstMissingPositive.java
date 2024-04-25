package LeetCode.Hard;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            while (nums[i] > 0 && nums[i] <= nums.length
                    && nums[nums[i] - 1] != nums[i] && nums[i] != i + 1) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
            i++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {

    }

}
