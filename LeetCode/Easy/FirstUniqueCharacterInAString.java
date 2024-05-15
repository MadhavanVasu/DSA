package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public int firstUniqCharWithoutMap(String s) {
        int min = -1;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            int firstIndex = s.indexOf(c);
            int lastIndex = s.lastIndexOf(c);
            if ((firstIndex != -1 && firstIndex == lastIndex) && (firstIndex < min || min == -1))
                min = firstIndex;
        }
        return min;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) map.put(x, map.getOrDefault(x, 0) + 1);
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
