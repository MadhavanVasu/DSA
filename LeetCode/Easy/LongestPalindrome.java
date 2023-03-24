package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {

        Map<Character, Integer> charMap = new HashMap<>();
        for (Character x : s.toCharArray()) {
            if (charMap.containsKey(x))
                charMap.put(x, charMap.get(x) + 1);
            else
                charMap.put(x, 1);
        }

        int count = 0;
        int f = 0;
        for (Character x : charMap.keySet()) {
            int c = charMap.get(x);
            count += (c / 2);
            if (c % 2 == 1)
                f = 1;
        }
        count *= 2;
        return (f == 1) ? count + 1 : count;
    }

    public static void main(String[] args) {

        String s = "aa";
        System.out.println(longestPalindrome(s));

    }

}
