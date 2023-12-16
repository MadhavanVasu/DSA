package Gfg.Medium;

public class HowManyXs {

    public int helper(int limit, int X) {
        int sum = 0;
        while (limit > 0) {
            int power = (int) Math.log10(limit);
            int firstDigit = (int) (limit / Math.pow(10, power));
            sum += (power * ((firstDigit * Math.pow(10, power)) / 10));
            if (firstDigit == X) {
                int remainder = (int) (limit % Math.pow(10, power));
                sum += (remainder + 1);
            } else if (firstDigit > X) {
                sum += Math.pow(10, power);
            }
            if (limit < 10) break;
            limit %= Math.pow(10, power);
        }
        return sum;
    }

    int countX(int L, int R, int X) {
        int sum1 = helper(L, X);
        int sum2 = helper(R - 1, X);
        return sum2 - sum1;
    }

    public static void main(String[] args) {

        System.out.println(new HowManyXs().countX(1, 996, 9));

    }

}
