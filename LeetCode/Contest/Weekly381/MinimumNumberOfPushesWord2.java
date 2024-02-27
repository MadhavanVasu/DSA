package LeetCode.Contest.Weekly381;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfPushesWord2 {
    public int minimumPushes(String word) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (Character c : word.toCharArray()) charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        int count = 1;
        int cycle = 0;
        int result = 0;
        while (true) {
            if (charCount.isEmpty()) break;
            int max = 0;
            char ch = 'a';
            for (Character c : charCount.keySet()) {
                if (charCount.get(c) > max) {
                    ch = c;
                    max = charCount.get(c);
                }
            }
            result += (8 * count);
            cycle++;
            if (cycle == 8) {
                cycle = 0;
                count++;
            }
            charCount.remove(ch);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
