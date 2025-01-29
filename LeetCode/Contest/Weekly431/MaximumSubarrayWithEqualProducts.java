package LeetCode.Contest.Weekly431;

public class MaximumSubarrayWithEqualProducts {

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public int lcm(int u, int v) {
        return (u / gcd(u, v)) * v;
    }

    public int maxLength(int[] nums) {
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int currGCD = nums[i];
            int product = nums[i];
            int currLCM = nums[i];
            for (int j = i + 1; j < n; j++) {
                int a = currGCD;
                int b = nums[j];
                if (a < b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                product *= nums[j];
                currGCD = gcd(a, b);
                a = currLCM;
                b = nums[j];
                if (a < b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                currLCM = lcm(a, b);
                if (product == currLCM * currGCD) {
                    if (j - i + 1 > max) max = j - i + 1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
