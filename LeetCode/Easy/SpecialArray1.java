package LeetCode.Easy;

public class SpecialArray1 {

    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
