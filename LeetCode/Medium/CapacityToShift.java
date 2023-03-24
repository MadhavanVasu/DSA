package LeetCode.Medium;


public class CapacityToShift {

    public static boolean feasible(int capacity, int[] weights, int days) {
        int day = 1;
        int total = 0;
        for (int weight : weights) {
            total += weight;
            if (total > capacity) {
                total = weight;
                day += 1;
                if (day > days)
                    return false;
            }
        }
        return true;
    }

    public static int shipWithinDaysBin(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int x : weights) if (x > max) max = x;
        for (int x : weights) sum += x;
        int left = max;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(left + " " + mid + " " + right);

            if (feasible(mid, weights, days))
                right = mid - 1;
            else
                left = mid + 1;

        }
        return left;
    }

    public static int helper(int i, int currWeight, int currDay, int days, int[] weights, int n, int[] dp) {
        if (currDay <= 0)
            return Integer.MAX_VALUE;
        if (i == n - 1) {
            if (currDay == 1)
                return currWeight + weights[i];
            else
                return Integer.MAX_VALUE;
        }
        if (dp[i] != -1)
            return dp[i];
        int b = helper(i + 1, 0, currDay - 1, days, weights, n, dp);
        b = Math.max(currWeight + weights[i], b);
        int a = helper(i + 1, currWeight + weights[i], currDay, days, weights, n, dp);
        a = Math.max(currWeight, a);

        return Math.min(a, b);

    }

    public static int shipWithinDays(int[] weights, int days) {

        int n = weights.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return helper(0, 0, days, days, weights, n, dp);

    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDaysBin(weights, days));

    }

}
