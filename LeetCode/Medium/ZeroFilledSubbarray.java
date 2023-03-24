package LeetCode.Medium;

public class ZeroFilledSubbarray {

    public long zeroFilledSubarray(int[] nums) {

        long result = 0;
        int prev = 0;
        for (int x : nums) {
            if (x == 0)
                prev++;
            else {
                result += (((long) prev * prev + 1) / 2);
                prev = 0;
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }

}
