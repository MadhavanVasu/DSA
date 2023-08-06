package LeetCode.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean helper(int i, String s, Set<String> wordDict, int[] dp) {
        if (i == s.length())
            return true;
        if (dp[i] != -1)
            return dp[i] != 0;
        for (int j = i; j < s.length(); j++) {
            if (wordDict.contains(s.substring(i, j + 1))) {
                if (helper(j + 1, s, wordDict, dp)) {
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i] = 0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) dp[i] = -1;
        return helper(0, s, set, dp);

    }

    public static void main(String[] args) {

    }

}
