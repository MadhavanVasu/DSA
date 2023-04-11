package LeetCode.Easy;

public class AlternatingDigitSum {

    public static int alternateDigitSumRightToLeft(int n) {
        int sign = 1;
        int res = 0;
        while (n > 0) {
            int r = n % 10;
            sign *= -1;
            res += (sign * r);
            n /= 10;
        }
        return sign * res;
    }

    public static int alternateDigitSum(int n) {

        int pow = (int) Math.floor(Math.log10(n));
        int div = (int) Math.pow(10, pow);
        int i = 0;
        int res = 0;
        while (div > 0) {
            int r = n / div;
            res += (i++ % 2 == 0) ? r : -r;
            n %= div;
            div /= 10;
        }
        return res;

    }

    public static void main(String[] args) {

        int n = 521;
        System.out.println(alternateDigitSum(n));

    }

}
