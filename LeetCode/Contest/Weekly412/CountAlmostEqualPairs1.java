package LeetCode.Contest.Weekly412;

public class CountAlmostEqualPairs1 {

    public int countPairs(int[] nums) {
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String num1 = String.valueOf(nums[i]);
                String num2 = String.valueOf(nums[j]);

                Integer digit1Diff1 = null;
                Integer digit1Diff2 = null;
                Integer digit2Diff1 = null;
                Integer digit2Diff2 = null;
                int x = 0;
                int y = 0;
                if (nums[i] == nums[j]) {
                    result++;
                    continue;
                }
                if (Math.abs(num1.length() - num2.length()) > 1) {
                    while (x < num1.length())
                    {

                    }
                }
                if (Math.abs(num1.length() - num2.length()) == 1) {
                    if ((nums[i] / nums[j] == 10 && nums[i] % nums[j] == 0) || (nums[j] / nums[i] == 10 && nums[j] % nums[i] == 0)) {
                        result++;
                    }
                    continue;
                }
                boolean flag = false;
                while (x < num1.length()) {
                    if (num1.charAt(x) != num2.charAt(y)) {
                        if (digit1Diff1 == null) {
                            digit1Diff1 = num1.charAt(x) - '0';
                            digit2Diff1 = num2.charAt(y) - '0';
                        } else if (digit1Diff2 == null) {
                            digit1Diff2 = num1.charAt(x) - '0';
                            digit2Diff2 = num2.charAt(y) - '0';
                        } else {
                            flag = true;
                            break;
                        }
                    }
                    x++;
                    y++;
                }
                if (digit1Diff2 == null || flag) continue;
                if (digit1Diff1 == digit2Diff2 && digit1Diff2 == digit2Diff1) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
