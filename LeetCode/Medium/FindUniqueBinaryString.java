package LeetCode.Medium;

public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        char[] nextBinaryString = new char[n];
        for (int i = 0; i < n; i++) {
            nextBinaryString[i] = '0';
        }
        while (true) {
            boolean flag = true;
            for (String x : nums) {
                if (new String(nextBinaryString).equals(x)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return new String(nextBinaryString);
            for (int i = n - 1; i >= 0; i--) {
                if (nextBinaryString[i] == '0') {
                    nextBinaryString[i] = '1';
                    for (int j = i + 1; j < n; j++)
                        nextBinaryString[j] = '0';
                }
            }
        }
    }

    public static void main(String[] args) {

    }

}
