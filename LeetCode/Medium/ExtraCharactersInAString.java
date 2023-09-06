package LeetCode.Medium;

import java.util.Arrays;

public class ExtraCharactersInAString {

    public int helper(int i, String s, String[] dictionary, int n, Integer[] dp) {
        if (i >= n) return 0;
        if (dp[i] != null) return dp[i];

        StringBuilder sb = new StringBuilder();
        int a = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            sb.append(s.charAt(j));
            if (Arrays.asList(dictionary).contains(sb.toString())) {
                int res = helper(j + 1, s, dictionary, n, dp);
                if (res < a) a = res;
            }
        }
        int b = 1 + helper(i + 1, s, dictionary, n, dp);
        dp[i] = Math.min(a, b);
        return dp[i];
    }

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Integer[] dp = new Integer[n];
        return helper(0, s, dictionary, n, dp);
    }

    public static void main(String[] args) {

//        System.out.println(new ExtraCharactersInAString().minExtraChar());

    }

}
