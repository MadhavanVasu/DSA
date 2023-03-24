package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountStringStartAndEndWithVowel {

    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = left; i <= right; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1)))
                res += 1;
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
