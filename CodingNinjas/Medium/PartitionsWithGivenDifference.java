package CodingNinjas.Medium;

public class PartitionsWithGivenDifference {

    public static int helper(int i, int sum, int totalSum, int n, int d, int[] arr, Integer[][] dp) {
        if (i >= n) return 0;
        if (dp[i][sum] != null) return dp[i][sum];
        int a = sum + arr[i] - (totalSum - (sum + arr[i])) == d ? 1 : 0;
        int res1 = helper(i + 1, sum + arr[i], totalSum, n, d, arr, dp);
        int res2 = helper(i + 1, sum, totalSum, n, d, arr, dp);
        dp[i][sum] = (a + res1 + res2) % 1000000007;
        return dp[i][sum];
    }

    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int x : arr) totalSum += x;
        Integer[][] dp = new Integer[n][totalSum + 1];
        return helper(0, 0, totalSum, n, d, arr, dp);
    }

    public static void main(String[] args) {

        System.out.println(countPartitions(4, 3, new int[]{5, 1, 5, 2}));
        System.out.println(countPartitions(4, 0, new int[]{1, 1, 1, 1}));
        System.out.println(countPartitions(5, 2, new int[]{1, 0, 1, 1, 1}));
        System.out.println(countPartitions(5, 4, new int[]{1, 0, 1, 1, 1}));
        System.out.println(countPartitions(4, 4, new int[]{1, 1, 1, 1}));

    }

}
