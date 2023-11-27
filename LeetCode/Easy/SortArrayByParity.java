package LeetCode.Easy;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int even = 0;
        int odd = n - 1;
        while (even < odd) {
            if (nums[even] % 2 == 0) {
                even++;
            } else {
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = temp;
                odd--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {

    }

}
