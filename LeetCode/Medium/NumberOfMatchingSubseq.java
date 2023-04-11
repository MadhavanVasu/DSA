package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubseq {

    public static boolean isSubsequenceMatching(int i, int j, String s, String word, int n, int m) {
        if (j >= m)
            return true;
        if (i >= n)
            return false;
        if (s.charAt(i) == word.charAt(j)) {
            return isSubsequenceMatching(i + 1, j + 1, s, word, n, m);
        } else
            return isSubsequenceMatching(i + 1, j, s, word, n, m);
    }

    public static int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String x : map.keySet()) {
            if (isSubsequenceMatching(0, 0, s, x, s.length(), x.length()))
                result += map.get(x);
        }
        return result;

    }

    public static void main(String[] args) {

        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        System.out.println(numMatchingSubseq(s, words));

    }
}
