package LeetCode.Contest.Biweekly126;

public class FindSumOfEncryptedIntegers {

    public int encrypt(int x) {
        String s = String.valueOf(x);
        int len = s.length();
        int max = 0;
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (digit > max) max = digit;
        }
        return Integer.parseInt(String.valueOf((char) (max + '0')).repeat(len));
    }

    public int sumOfEncryptedInt(int[] nums) {
        int result = 0;
        for (int x : nums) result += encrypt(x);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindSumOfEncryptedIntegers().sumOfEncryptedInt(new int[]{1, 2, 3}));
    }

}
