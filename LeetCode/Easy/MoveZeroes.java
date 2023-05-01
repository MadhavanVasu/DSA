package LeetCode.Easy;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int currPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[currPos];
                nums[currPos] = nums[i];
                nums[i] = temp;
                currPos++;
            }
        }

    }

    public static void main(String[] args) {

    }

}
