package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class CountCompleteSubstrings {

    public int countCompleteSubstrings(String word, int k) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        int result = 0;
        int count = 0;
        Character prev = null;
        int start = 0;
        for (int i = 0; i < word.length(); i++) {
            charCountMap.put(word.charAt(i), charCountMap.getOrDefault(word.charAt(i), 0) + 1);
            if (prev != null) {
                int diff = Math.abs((int) word.charAt(i) - (int) prev);
                if (diff > 2) {
                    result += ((count * (count + 1)) / 2);
                    count = 0;
                    charCountMap = new HashMap<>();
                    charCountMap.put(word.charAt(i), 1);
                    start = i;
                }
            }
            if (charCountMap.get(word.charAt(i)) > k) {
                result += ((count * (count + 1)) / 2);
                for (int j = start; j < i; j++) {
                    if (word.charAt(j) == word.charAt(i)) {
                        start = j + 1;
                        i = j + 1;
                        charCountMap = new HashMap<>();
                        count = 0;
                        break;
                    }
                }
            }
            prev = word.charAt(i);
            boolean flag = true;
            for (char x : charCountMap.keySet()) {
                if (charCountMap.get(x) != k) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        result += ((count * (count + 1)) / 2);
        return result;
    }

    public static void main(String[] args) {

    }

}
