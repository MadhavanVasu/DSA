package LeetCode.Contest.Weekly391;

public class HarshadNumber {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int temp = x;
        while (temp > 0) {
            sum += (temp % 10);
            temp /= 10;
        }
        if (sum != 0 && x % sum == 0) return sum;
        return -1;
    }

    public static void main(String[] args) {

    }

}
