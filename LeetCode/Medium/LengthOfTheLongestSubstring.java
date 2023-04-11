package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfTheLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        int start = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
                int length = i - start;
                if (length > max)
                    max = length;
                start = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
        }
        if(i-start> max)
            max = i - start;
        return max;

    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(new LengthOfTheLongestSubstring().lengthOfLongestSubstring(s));
    }

}
