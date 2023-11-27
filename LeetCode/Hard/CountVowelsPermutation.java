package LeetCode.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountVowelsPermutation {

    public int helper(int i, int length, int n, char[] vowels, Map<Integer, List<Integer>> connected, Integer[][] dp) {
        if (length == 0) return 1;
        if (dp[i][length] != null) return dp[i][length];
        int ans = 0;
        if (length == n) {
            for (int j = 0; j < 5; j++) {
                if (length == 1) ans += 1;
                else {
                    for (int x : connected.get(j)) {
                        ans = (ans + helper(x, length - 1, n, vowels, connected, dp)) % (1000000007);
                    }
                }
            }
        } else {
            if(length==1) return 1;
            for (int x : connected.get(i)) {
                ans = (ans + helper(x, length - 1, n, vowels, connected, dp)) % (1000000007);
            }
        }
        dp[i][length] = ans % (1000000007);
        return dp[i][length];
    }

    public int countVowelPermutation(int n) {

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        Map<Integer, List<Integer>> connected = new HashMap<>();
        connected.put(0, new ArrayList<>(List.of(1)));
        connected.put(1, new ArrayList<>(List.of(0, 2)));
        connected.put(2, new ArrayList<>(List.of(0, 1, 3, 4)));
        connected.put(3, new ArrayList<>(List.of(2, 4)));
        connected.put(4, new ArrayList<>(List.of(0)));
        Integer[][] dp = new Integer[5][n + 1];
        return helper(0, n, n, vowels, connected, dp);
    }

    public static void main(String[] args) {
        System.out.println(new CountVowelsPermutation().countVowelPermutation(2));
    }

}
