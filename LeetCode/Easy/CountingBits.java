package LeetCode.Easy;

public class CountingBits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        int nextPower = 1;
        int prev = 0;
        int i = 1;
        while (i < n + 1) {
            if (i == nextPower) {
                result[i] = nextPower;
                prev = nextPower;
                nextPower *= 2;
            } else {
                int diff = i - prev;
                result[i] = result[diff] + 1;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
