package LeetCode.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeWithFactors {

    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[n];
        Arrays.sort(arr);
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++)
            map.put(arr[i], i);
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] % arr[j] == 0) {
                    int quo = arr[i] / arr[j];
                    if (map.containsKey(quo)) {
                        long temp = ((long) dp[j] * dp[map.get(quo)]);
                        dp[i] = (int) ((dp[i] + temp) % MOD);
                    }
                }
            }
        }
        int result = 0;
        for (int x : dp) {
            result = (result + x) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new BinaryTreeWithFactors().numFactoredBinaryTrees(new int[]{46, 144, 5040, 4488, 544, 380, 4410, 34, 11, 5, 3063808, 5550, 34496, 12, 540, 28, 18, 13, 2, 1056, 32710656, 31, 91872, 23, 26, 240, 18720, 33, 49, 4, 38, 37, 1457, 3, 799, 557568, 32, 1400, 47, 10, 20774, 1296, 9, 21, 92928, 8704, 29, 2162, 22, 1883700, 49588, 1078, 36, 44, 352, 546, 19, 523370496, 476, 24, 6000, 42, 30, 8, 16262400, 61600, 41, 24150, 1968, 7056, 7, 35, 16, 87, 20, 2730, 11616, 10912, 690, 150, 25, 6, 14, 1689120, 43, 3128, 27, 197472, 45, 15, 585, 21645, 39, 40, 2205, 17, 48, 136}));

    }

}
