package IQns;

import java.util.HashSet;
import java.util.Set;

public class FindValidCombinations {

    int MOD = 998244353;

    public int helper(int i, Set<Integer> numSet, int rem, int A, int B, int prev, Integer[][][] dp) {
        if (i >= A) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][rem][prev] != null) return dp[i][rem][prev];
        int ans = 0;
        for (int j = 1; j <= B; j++) {
            if (prev != j) {
                numSet.add(j);
                int k = 1;
                if (rem == 0) ans++;
                else {
                    while (true) {
                        System.out.println("hi" +" " + i);
                        int tempAns = (helper(i + k, numSet, rem - 1, A, B, j, dp));
                        if (tempAns == Integer.MAX_VALUE) break;
                        ans = (tempAns + ans) % MOD;
                        k++;
                    }
                }
                numSet.remove(j);
            }
        }
        dp[i][rem][prev] = ans;
        return ans;
    }

    public long validCombinations(int A, int B, int C) {
        Integer[][][] dp = new Integer[A + 1][C + 1][B + 1];
        return helper(0, new HashSet<>(), C, A, B, 0, dp);
    }

    public static void main(String[] args) {
        System.out.println(new FindValidCombinations().validCombinations(100, 100, 30));
    }

}
//
//1 1 1 2
//1 1 1 3
//1 1 1 4
//1 1 2 2
//1 1 3 3
//1 1 4 4
//1 2 2 2
//1 3 3 3
//1 4 4 4

// 1 1 2 1
// 1 2 1 1
// 1 1 2 3
// 1 1 3 2
// 1 2 3 3
// 1 1 2 4
// 1 1 4 2
// 1 2 4 4
// 1 4 2 2
// 1 3 2 2
// 1 1 3 4
// 1 1 4 3
// 1 3 4 4
// 1 4 3 3
// 1 1 4 1
// 1 4 1 1
// 1 1 3 1
// 1 3 1 1
// 1 3 3 1
// 1 4 4 1
// 1 2 2 1
// 1 4 4 2
// 1 4 4 3
// 1 4 4 2
// 1 3 3 4
// 1 2 2 4
// 1 3 3 2






