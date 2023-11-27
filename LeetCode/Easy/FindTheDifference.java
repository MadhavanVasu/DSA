package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {

    public char findTheDifferenceUsingXOR(String s, String t) {
        char ret = '\0';
        for (Character c : s.toCharArray()) ret ^= c;
        for (Character c : t.toCharArray()) ret ^= c;
        return ret;
    }

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : s.toCharArray()) {
            tMap.put(c, tMap.get(c) - 1);
        }
        for (Character c : tMap.keySet()) {
            if (tMap.get(c) != 0)
                return c;
        }
        return '\0';
    }

    public static void main(String[] args) {

    }

}
