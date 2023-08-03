package LeetCode.Contest.Weekly351;

public class NumberOfBeautifulPairs {

    public int gcd(int a, int b) {

        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a == b)
            return a;
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }


    public int countBeautifulPairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = (nums[i] / (int) Math.pow(10, (int) Math.log10(nums[i])));
                int gcd = gcd(x, nums[j] % 10);
                if (gcd == 1) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
