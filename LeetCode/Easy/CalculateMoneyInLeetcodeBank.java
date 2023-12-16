package LeetCode.Easy;

public class CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        int rem = 0;
        int ans = 0;
        while (n > 0) {
            int days;
            if (n >= 7) {
                days = 7;
                n -= 7;
            } else {
                days = n;
                n = 0;
            }
            int sum1 = ((rem + days) * (rem + days + 1)) / 2;
            int sum2 = (rem * (rem + 1)) / 2;
            ans += sum1 - sum2;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
