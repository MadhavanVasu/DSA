package LeetCode.Medium;

public class MinimumSumOfKAvoiding {

    public int minimumSum(int n, int k) {

        int sum = 0;
        for (int i = 1; i <= k / 2; i++) {
            if (n > 0) {
                sum += i;
                n--;
            } else break;
        }
        if (n > 0) {
            int i = k;
            while (n > 0) {
                sum += i;
                i++;
                n--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
