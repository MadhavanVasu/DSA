package LeetCode.Contest.Biweekly101;

import java.util.HashMap;
import java.util.Map;

public class StringWithMaxCost {

    public static int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++)
            map.put(i, i + 1);
        for (int i = 0; i < chars.length(); i++) {
            int ascii = chars.charAt(i) - 'a';
            map.put(ascii, vals[i]);
        }
        int max = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i) - 'a';
            sum += map.get(ascii);
            if (sum < map.get(ascii))
                sum = map.get(ascii);
            if (sum > max)
                max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abc";
        String chars = "abc";
        int[] vals = {-1, -1, -1};
        System.out.println(maximumCostSubstring(s, chars, vals));
    }
}
