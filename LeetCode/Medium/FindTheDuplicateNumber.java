package LeetCode.Medium;

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int sum1 = ((n - 1) * n) / 2;
        int sum2 = 0;
        for (int x : nums) sum2 += x;
        return sum2 - sum1;
    }

    public static void main(String[] args) {

    }

}
