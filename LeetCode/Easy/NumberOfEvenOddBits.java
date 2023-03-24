package LeetCode.Easy;

public class NumberOfEvenOddBits {

    public int[] evenOddBit(int n) {

        int[] result = new int[2];
        int flag = 0;
        while (n > 0) {
            if (n % 2 == 1)
                result[flag]++;
            flag = (flag + 1) % 2;
            n = n / 2;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
