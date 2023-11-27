package LeetCode.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueLength3PalindromicSubsequence {

    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> freqMap = new HashMap<>();
        int[] resultCount = new int[26];
        int result = 0;
        for (char x : s.toCharArray()) {
            if (!map.containsKey(x)) {
                map.put(x, new HashSet<>());
                freqMap.put(x, 0);
            }
            freqMap.put(x, freqMap.get(x) + 1);
            if (freqMap.get(x) == 3) result += 1;
            for (Character ch : map.keySet()) {
                map.get(ch).add(x);
            }
            if (freqMap.get(x) > 1) {
                int index = x - 'a';
                resultCount[index] = map.get(x).size() - 1;
            }
        }
        for (int x : resultCount)
            result += x;
        return result;
    }

    public static void main(String[] args) {

    }

}
