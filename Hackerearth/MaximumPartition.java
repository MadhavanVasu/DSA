package Hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximumPartition {

    public int helper(int i, int j, int[] nums, int n, Integer[][] dp) {
        if (i >= n) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int sign = j == 0 ? 1 : -1;
        if (i == n - 1)
            return (sign * nums[i]);
        int a = (sign * nums[i]) + helper(i + 1, j, nums, n, dp);
        int temp = j == 0 ? 1 : 0;
        int b = (sign * nums[i]) + helper(i + 1, temp, nums, n, dp);
        dp[i][j] = Math.max(a, b);
        return dp[i][j];
    }

    public int maximumPartitionSum(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][2];
        return helper(0, 0, nums, n, dp);
    }


    public static void main(String args[]) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stringNums = br.readLine().split(" ");
        List<Integer> integernums = new ArrayList<>();
        for (String x : stringNums) {
            integernums.add(Integer.parseInt(x));
        }
        System.out.println(integernums);

        System.out.println(Arrays.toString(stringNums));

        System.out.println(new MaximumPartition().maximumPartitionSum(new int[]{1, 1, 2, -10, 2, 1}));
    }


}
